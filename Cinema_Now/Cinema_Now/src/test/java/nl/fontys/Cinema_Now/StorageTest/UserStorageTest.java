package nl.fontys.Cinema_Now.StorageTest;

import nl.fontys.Cinema_Now.Modules.User;
import nl.fontys.Cinema_Now.Repository.FakeDataUsers;
import nl.fontys.Cinema_Now.Services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserStorageTest {
    @Test
    public void addUserTest()
    {
        UserService data = new UserService(new FakeDataUsers());
        User user1 = new User("Anna", "Johnsson","a.johnsson@gmail.com","Pastor Peterstraat",24);
        data.addUser(user1);

        Assertions.assertEquals(user1, data.getUserByID(user1.getID()));

    }

    @Test
    public void deleteUserExistentTest()
    {
        UserService data = new UserService(new FakeDataUsers());
        User user1 = new User("Anna", "Johnsson","a.johnsson@gmail.com","Pastor Peterstraat",24);
        data.deleteUser(user1.getID());

        List<User> result = data.getAllUsers();

        Assertions.assertFalse(result.isEmpty());

    }
    @Test
    public void getUserByIDTest()
    {
        UserService data = new UserService(new FakeDataUsers());
        User user1 = new User("Anna", "Johnsson","a.johnsson@gmail.com","Pastor Peterstraat",24);
        int id  = user1.getID();
        data.getUserByID(user1.getID());

        Assertions.assertEquals(user1.getID(),id);
    }
    @Test
    public void editUserTest()
    {
        UserService data = new UserService(new FakeDataUsers());
        User user1 = new User("Anna", "Johnsson","a.johnsson@gmail.com","Pastor Peterstraat",24);
        data.editUser(user1);


    }
}
