package nl.fontys.Cinema_Now.Controllers;
import nl.fontys.Cinema_Now.DTO.News;
import nl.fontys.Cinema_Now.DTO.User;
import nl.fontys.Cinema_Now.Interfaces.Managers.IMovieService;
import nl.fontys.Cinema_Now.Interfaces.Managers.IUserService;
import nl.fontys.Cinema_Now.Repository.FakeDataUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
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
        List<User> users = service.GetAllUsers();

        if(users != null) {
            return ResponseEntity.ok().body(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    //GET at http://localhost:8080/users/100
    public ResponseEntity<User> getUserPath(@PathVariable(value = "id") int id) {
        User user = service.GetUserByID(id);

        if(user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    //POST at http://localhost:XXXX/users/
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (!service.AddUser(user)){
            String entity =  "User  " + user.getEmail()+ " already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {
            String url = "user" + "/" + user.getID(); // url of the created student
            URI uri = URI.create(url);
            return new ResponseEntity(uri,HttpStatus.CREATED);
        }

    }

    @DeleteMapping()
    //DELETE at http://localhost:XXXX/users/
    public ResponseEntity<User> deleteUser(@RequestBody int id) {
        service.deleteUser(id);
        return ResponseEntity.ok().build();

    }

    @PutMapping("{id}")
    //PUT at http://localhost:XXXX/users/102
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName)
    {
        User user = service.GetUserByID(id);
        if(user == null)
        {
            return new ResponseEntity("Please provide a valid id", HttpStatus.NOT_FOUND);
        }

        user.setFirstName(firstName);
        user.setLastName(lastName);

        return ResponseEntity.noContent().build();
    }


}
