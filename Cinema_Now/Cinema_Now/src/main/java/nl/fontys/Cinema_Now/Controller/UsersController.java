package nl.fontys.Cinema_Now.Controller;
import nl.fontys.Cinema_Now.DTO.UserDTO;
import nl.fontys.Cinema_Now.Model.User;
import nl.fontys.Cinema_Now.ServiceInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UsersController {
    private IUserService service;

    @Autowired
    public UsersController(IUserService service)
    {
        this.service=service;
    }

    //GET at /users
    @GetMapping
    public ResponseEntity<List<User>> getUsers()
    {
        List<User> users = service.getAllUsers();

        if(users != null) {
            return ResponseEntity.ok().body(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    //GET at http://localhost:8080/users/100
    public ResponseEntity<User> getUserPath(@PathVariable(value = "id") String id) {
        User user = service.getUserByID(id);

        if(user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/sign-up")
    //POST at http://localhost:XXXX/users/sign-up
    public ResponseEntity<User> createUser(@RequestBody UserDTO user) {
        if (user == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            service.addUser(user);
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("{id}")
    //DELETE at http://localhost:XXXX/users/
    public ResponseEntity<User> deleteUser(@PathVariable("id") String id) {
        service.deleteUser(id);
        return ResponseEntity.ok().build();

    }

    @PutMapping("{id}")
    //PUT at http://localhost:XXXX/users/102
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName)
    {
        User user = service.getUserByID(id);
        if(user == null)
        {
            return new ResponseEntity("Please provide a valid id", HttpStatus.NOT_FOUND);
        }

        user.setFirstName(firstName);
        user.setLastName(lastName);

        return ResponseEntity.noContent().build();
    }


}
