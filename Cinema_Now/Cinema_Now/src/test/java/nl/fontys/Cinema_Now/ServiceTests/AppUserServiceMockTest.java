package nl.fontys.Cinema_Now.ServiceTests;

import nl.fontys.Cinema_Now.Converter.UserConverter;
import nl.fontys.Cinema_Now.DALInterfaces.IUserDAL;
import nl.fontys.Cinema_Now.DTO.UserDTO;
import nl.fontys.Cinema_Now.Model.AppUser;
import nl.fontys.Cinema_Now.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
public class AppUserServiceMockTest {
    @Mock
    private IUserDAL userDAL;


    @BeforeEach
    public void setUp()
    {
        List<AppUser> appUsers = List.of(
                new AppUser("1","Andreea","Sindrilaru","deeagirl1@gmail.com","Boschdijk 42-E",20),
                new AppUser("2","Iris","Johnson","i.johnson@gmail.com","Passtor 42-E",30),
                new AppUser("3","Maria","Zavaranu","m.zavaranu@gmail.com","Hoogstraat 42-E",40)

        );


        when(userDAL.getUserByID("1")).thenReturn(appUsers.get(0));
        when(userDAL.deleteUser("1")).thenReturn(true);
        when(userDAL.getAllUsers()).thenReturn(appUsers);
    }

    @Test
    public void getAllUserTest()
    {
        //arrange
        UserService service = new UserService(userDAL,new UserConverter());
        //act
        List<AppUser> appUsers = service.getAllUsers();

        //assert
        Assertions.assertEquals("1", appUsers.get(0).getId());
        Assertions.assertEquals("2", appUsers.get(1).getId());
        Assertions.assertEquals("3", appUsers.get(2).getId());
    }
    @Test
    public void getUserByID()
    {
        //arrange
        UserService service = new UserService(userDAL,new UserConverter());
        AppUser appUser = new AppUser("4","Maria","Zavaranu","m.zavaranu@gmail.com","Hoogstraat 42-E",40);
        //act
        when(userDAL.getUserByID("4")).thenReturn(appUser);
        AppUser appUserToBeChecked =service.getUserByID("4");

        //assert
        Assertions.assertEquals("Maria", appUserToBeChecked.getFirstName());
    }

    @Test
    public void deleteUserTest_returnTrue()
    {

        //arrange
        UserService service = new UserService(userDAL,new UserConverter());
        //act
        List<AppUser> appUsers = service.getAllUsers();
        var result = service.deleteUser(appUsers.get(0).getId());

        Assertions.assertTrue(result);

    }

    @Test
    public void addUserTest_returnTrue()
    {
        //arrange
        UserService service = new UserService(userDAL,new UserConverter());
        //act
        UserDTO user = new UserDTO("1","deeagirl1@gmail.com","Andreea","Sindrilaru","123", "m.zavaroanu@gmail.com");
        service.addUser(user);

        ArgumentCaptor<AppUser> userArgumentCaptor = ArgumentCaptor.forClass(AppUser.class);

        verify(userDAL).addUser(userArgumentCaptor.capture());

        AppUser captureAppUser = userArgumentCaptor.getValue();

        Assertions.assertEquals(user.getUsername(), captureAppUser.getUsername());

    }

    @Test
    public void updateUserTest_returnTrue()
    {
        UserService service = new UserService(userDAL, new UserConverter());
        //act
        UserDTO user = new UserDTO("1","deeagirl1@gmail.com","Andreea","Sindrilaru","123", "m.zavaroanu@gmail.com");
        service.addUser(user);

        user.setUsername("Test");
        service.editUser(user);

        ArgumentCaptor<AppUser> userArgumentCaptor = ArgumentCaptor.forClass(AppUser.class);

        verify(userDAL).editUser(userArgumentCaptor.capture());

        AppUser captureAppUser = userArgumentCaptor.getValue();

        Assertions.assertEquals(user.getUsername(), captureAppUser.getUsername());

    }

}
