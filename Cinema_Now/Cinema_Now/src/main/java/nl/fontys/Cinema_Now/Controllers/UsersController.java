package nl.fontys.Cinema_Now.Controllers;
import nl.fontys.Cinema_Now.DTO.User;
import nl.fontys.Cinema_Now.Repository.FakeDataUsers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {
    private static final FakeDataUsers fakeData = new FakeDataUsers();

    //GET at /users
    @GetMapping
    public ResponseEntity<List<User>> getUsers(@RequestParam(value = "id") Optional<Integer> id)
    {
        List<User> users = fakeData.GetAllUsers();

        if(users != null) {
            return ResponseEntity.ok().body(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}") //GET at http://localhost:8080/user/100
    public ResponseEntity<User> getUserPath(@PathVariable(value = "id") int id) {
        User user = fakeData.GetUserByID(id);

        if(user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    //POST at http://localhost:XXXX/students/
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (!fakeData.AddUser(user)){
            String entity =  "User with ID " + user.getID() + " already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {
            String url = "user" + "/" + user.getID(); // url of the created student
            URI uri = URI.create(url);
            return new ResponseEntity(uri,HttpStatus.CREATED);
        }

    }


}
