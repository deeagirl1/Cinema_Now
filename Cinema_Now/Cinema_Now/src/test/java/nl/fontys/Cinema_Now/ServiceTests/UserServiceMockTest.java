package nl.fontys.Cinema_Now.ServiceTests;

import nl.fontys.Cinema_Now.DALInterfaces.IUserDAL;
import nl.fontys.Cinema_Now.Model.User;
import nl.fontys.Cinema_Now.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
public class UserServiceMockTest {
    @Mock
    private IUserDAL userDAL;


    @BeforeEach
    public void setUp()
    {
        List<User> users = List.of(
                new User("1","Andreea","Sindrilaru","deeagirl1@gmail.com","Boschdijk 42-E",20),
                new User("2","Iris","Johnson","i.johnson@gmail.com","Passtor 42-E",30),
                new User("3","Maria","Zavaranu","m.zavaranu@gmail.com","Hoogstraat 42-E",40)

        );


        when(userDAL.getUserByID("1")).thenReturn(users.get(0));
        when(userDAL.deleteUser("1")).thenReturn(true);
        when(userDAL.getAllUsers()).thenReturn(users);
    }

    @Test
    public void getAllUserTest()
    {
        //arrange
        UserService service = new UserService(userDAL);
        //act
        List<User> users = service.getAllUsers();

        //assert
        Assertions.assertEquals(users.get(0).getID(),"1");
        Assertions.assertEquals(users.get(1).getID(),"2");
        Assertions.assertEquals(users.get(2).getID(),"3");
    }
    @Test
    public void getUserByID()
    {
        //arrange
        UserService service = new UserService(userDAL);
        User user = new User("4","Maria","Zavaranu","m.zavaranu@gmail.com","Hoogstraat 42-E",40);
        //act
        when(userDAL.getUserByID("4")).thenReturn(user);
        User userToBeChecked =service.getUserByID("4");

        //assert
        Assertions.assertEquals(userToBeChecked.getFirstName(),"Maria");
    }

    @Test
    public void deleteUserTest_returnTrue()
    {

        //arrange
        UserService service = new UserService(userDAL);
        //act
        List<User> users = service.getAllUsers();
        var result = service.deleteUser(users.get(0).getID());

        Assertions.assertTrue(result);

    }

    @Test
    public void addUserTest_returnTrue()
    {
        //arrange
        UserService service = new UserService(userDAL);
        //act
        User user = new User("3","Maria","Zavaranu","m.zavaranu@gmail.com","Hoogstraat 42-E",40);
        service.addUser(user);

        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);

        verify(userDAL).addUser(userArgumentCaptor.capture());

        User captureUser = userArgumentCaptor.getValue();

        Assertions.assertEquals(user,captureUser);

    }

    @Test
    public void updateUserTest_returnTrue()
    {
        UserService service = new UserService(userDAL);
        //act
        User user = new User("4","Maria","Zavaranu","m.zavaranu@gmail.com","Hoogstraat 42-E",40);
        service.addUser(user);

        user.setEmail("Test");
        service.editUser(user);

        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);

        verify(userDAL).addUser(userArgumentCaptor.capture());

        User captureUser = userArgumentCaptor.getValue();

        Assertions.assertEquals(user,captureUser);

    }

}