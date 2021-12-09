package nl.fontys.Cinema_Now.serviceTests;

import nl.fontys.Cinema_Now.converters.NewsConverter;
import nl.fontys.Cinema_Now.converters.UserConverter;
import nl.fontys.Cinema_Now.dalInterfaces.IComplaintDAL;
import nl.fontys.Cinema_Now.dalInterfaces.IProjectionDAL;
import nl.fontys.Cinema_Now.dalInterfaces.ITicketDAL;
import nl.fontys.Cinema_Now.dalInterfaces.IUserDAL;
import nl.fontys.Cinema_Now.dto.NewsDTO;
import nl.fontys.Cinema_Now.dto.UserDTO;
import nl.fontys.Cinema_Now.model.AppUser;
import nl.fontys.Cinema_Now.model.Complaint;
import nl.fontys.Cinema_Now.model.Enums.TicketType;
import nl.fontys.Cinema_Now.model.News;
import nl.fontys.Cinema_Now.model.Ticket;
import nl.fontys.Cinema_Now.service.NewsService;
import nl.fontys.Cinema_Now.service.UserService;
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
    @Mock
    private ITicketDAL ticketDAL;
    @Mock
    private IComplaintDAL complaintDAL;
    @Mock
    private IProjectionDAL projectionDAL;

    private UserService service;
    private UserConverter converter = new UserConverter();

    @BeforeEach
    public void setUp()
    {
        service = new UserService(userDAL,converter);
        List<AppUser> appUsers = List.of(
                new AppUser("1","Andreea","Sindrilaru","deeagirl1@gmail.com","Boschdijk 42-E",20),
                new AppUser("2","Iris","Johnson","i.johnson@gmail.com","Passtor 42-E",30),
                new AppUser("3","Maria","Zavaranu","m.zavaranu@gmail.com","Hoogstraat 42-E",40)

        );


        when(userDAL.getUserByID("1")).thenReturn(appUsers.get(0));
        when(userDAL.deleteUser("1")).thenReturn(true);
        when(userDAL.getAllUsers()).thenReturn(appUsers);
        when(userDAL.editUser(appUsers.get(0))).thenReturn(appUsers.get(0));
    }

    @Test
    public void getAllUserTest()
    {
        //arrange
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
        //act
        List<AppUser> appUsers = service.getAllUsers();
        var result = service.deleteUser(appUsers.get(0).getId());
        Assertions.assertTrue(result);
    }

    @Test
    public void addUserTest_returnTrue()
    {
        //act
        AppUser user =  new AppUser("4","Maria","Zavaranu","m.zavaranu@gmail.com","Hoogstraat 42-E",40);
        service.addUser(converter.entityToDto(user));

        ArgumentCaptor<AppUser> userArgumentCaptor = ArgumentCaptor.forClass(AppUser.class);

        verify(userDAL).addUser(userArgumentCaptor.capture());

        AppUser captureAppUser = userArgumentCaptor.getValue();

        Assertions.assertEquals(user.getUsername(), captureAppUser.getUsername());

    }

    @Test
    public void updateUserTest()
    {
        //act
        AppUser user =  service.getUserByID("1");
        user.setUsername("Test");
        service.editUser(converter.entityToDto(user));

        ArgumentCaptor<AppUser> userArgumentCaptor = ArgumentCaptor.forClass(AppUser.class);

        verify(userDAL).editUser(userArgumentCaptor.capture());

        AppUser captureAppUser = userArgumentCaptor.getValue();

        Assertions.assertEquals(user.getUsername(), captureAppUser.getUsername());


    }

}
