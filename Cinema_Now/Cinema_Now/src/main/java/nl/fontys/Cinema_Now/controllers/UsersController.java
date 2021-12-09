package nl.fontys.Cinema_Now.controllers;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import nl.fontys.Cinema_Now.dto.RoleToUserForm;
import nl.fontys.Cinema_Now.dto.UserDTO;
import nl.fontys.Cinema_Now.model.AppUser;
import nl.fontys.Cinema_Now.model.Role;
import nl.fontys.Cinema_Now.serviceInterface.IUserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UsersController {

    private final IUserService service;

    @Autowired
    public UsersController(IUserService service)
    {
        this.service=service;
    }

    //GET at /users
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<AppUser>> getUsers()
    {
        List<AppUser> appUsers = service.getAllUsers();

        if(appUsers != null) {
            return ResponseEntity.ok().body(appUsers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/profile/{username}")
    //GET at http://localhost:8080/users/100
    public ResponseEntity<AppUser> getUserByName(@PathVariable("username") String username) {
        AppUser user = this.service.getUser(username);
//        UserDTO loggedInUser = this.converter.entityToDto(user);
        if(user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/sign-up")
    //POST at http://localhost:XXXX/users/sign-up
    public ResponseEntity<?> createUser(@RequestBody @NotNull UserDTO user) {
        if (service.getUser(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken");
        } else {
            service.addUser(user);
            service.addRoleToUser(user.getUsername(),"ROLE_USER");
            return ResponseEntity.ok().body(user);
        }
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    //DELETE at http://localhost:XXXX/users/
    public ResponseEntity<?>deleteUser(@PathVariable("id") String id) {
        service.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    //PUT at http://localhost:XXXX/user
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO dto)
    {
       if(service.editUser(dto) == null) {
           return ResponseEntity.noContent().build();
       }
       else {
           return  ResponseEntity.ok().body(dto);
       }
    }

    @PostMapping("/role/adduser")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    //POST at http://localhost:XXXX/users/role/addtouser
    public ResponseEntity<Role> addRoleToUser(@RequestBody RoleToUserForm form) {
        if (form == null) {
            return  ResponseEntity.notFound().build();
        } else {
            service.addRoleToUser(form.getUsername(),form.getRoleName());
            return ResponseEntity.ok().build();
        }
    }


    @GetMapping("/token/refresh")
    //POST at http://localhost:XXXX/users/token/refresh
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception{
       String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer "))
        {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                AppUser user = service.getUser(username);
                String access_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token",access_token);
                tokens.put("refresh_token",refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),tokens);
            }
            catch (Exception e)
            {
                response.setHeader("error", e.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message",e.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),error);
            }
        }
        else
        {
            throw new RuntimeException("Refresh token is missing");
        }
    }

}
