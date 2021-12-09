package nl.fontys.Cinema_Now.serviceTests;

import nl.fontys.Cinema_Now.converters.MovieConverter;
import nl.fontys.Cinema_Now.converters.ProjectionConverter;
import nl.fontys.Cinema_Now.converters.TicketConverter;
import nl.fontys.Cinema_Now.converters.UserConverter;
import nl.fontys.Cinema_Now.dalInterfaces.*;
import nl.fontys.Cinema_Now.dto.*;
import nl.fontys.Cinema_Now.model.*;
import nl.fontys.Cinema_Now.model.Enums.Format;
import nl.fontys.Cinema_Now.model.Enums.Genre;
import nl.fontys.Cinema_Now.model.Enums.TicketType;
import nl.fontys.Cinema_Now.service.MovieService;
import nl.fontys.Cinema_Now.service.TicketService;
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
public class TicketServiceTest {
    @Mock
    private ITicketDAL ticketDAL;
    @Mock
    private IUserDAL userDAL;
    @Mock
    private IMovieDAL movieDAL;
    @Mock
    private IRoomDAL roomDAL;
    @Mock
    private IProjectionDAL projectionDAL;

    private TicketService service;
    @BeforeEach
    public void setUp()
    {
        service = new TicketService(ticketDAL,userDAL,movieDAL,new TicketConverter(),roomDAL,projectionDAL);

        List<Room> rooms = List.of(
                new Room("1","test",20),
                new Room("2","test",20),
                new Room("3","test",20)
        );

        List<AppUser> appUsers = List.of(
                new AppUser("1","Andreea","Sindrilaru","deeagirl1@gmail.com","Boschdijk 42-E",20),
                new AppUser("2","Iris","Johnson","i.johnson@gmail.com","Passtor 42-E",30),
                new AppUser("3","Maria","Zavaranu","m.zavaranu@gmail.com","Hoogstraat 42-E",40)

        );

        List<Projection> projections = List.of(
                new Projection("1","25/05/2021","15:00"),
                new Projection("2","26/05/2021","15:00"),
                new Projection("3","27/05/2021","15:00")
        );

        Movie movie = new Movie("1","Cars", Genre.ANIMATION, 180, "06/06/2006", "Explore Radiator Spring with Lighting McQueen and Tow Mater.", Format._3D,"test",rooms.get(0),projections);

        List<Ticket> tickets = List.of(
                new Ticket("1",TicketType.ADULT,0,20, appUsers.get(0),movie, rooms.get(0),projections.get(0)),
                new Ticket("2",TicketType.ADULT,0,20, appUsers.get(1),movie, rooms.get(1),projections.get(1)),
                new Ticket("",TicketType.ADULT,0,20, appUsers.get(2),movie, rooms.get(2),projections.get(2))

        );

        when(userDAL.getUserByID("1")).thenReturn(appUsers.get(0));
        when(userDAL.deleteUser("1")).thenReturn(true);
        when(userDAL.getAllUsers()).thenReturn(appUsers);

        when(ticketDAL.getAllTickets()).thenReturn(tickets);
        when(ticketDAL.delete("1")).thenReturn(true);
        when(ticketDAL.getTicketById("1")).thenReturn(tickets.get(0));

        when(roomDAL.getAllRooms()).thenReturn(rooms);
        when(roomDAL.deleteRoom("1")).thenReturn(true);
        when(roomDAL.getRoomById("1")).thenReturn(rooms.get(0));

        when(projectionDAL.getAllProjections()).thenReturn(projections);
        when(projectionDAL.deleteProjection("1")).thenReturn(true);
        when(projectionDAL.getProjectionById("1")).thenReturn(projections.get(0));

        when(movieDAL.getMovie(movie.getId())).thenReturn(movie);
    }

    @Test
    public void getAllTicketsTest()
    {
        //act
        List<TicketDTO> tickets = service.getAllTickets();

        //assert
        Assertions.assertEquals("1", tickets.get(0).getId());
        Assertions.assertEquals("2", tickets.get(1).getId());
    }
    @Test
    public void getTicketById()
    {
        //act
        TicketDTO ticket = service.getTicketById("1");
        //assert
        Assertions.assertEquals("1",ticket.getId());
    }

    @Test
    public void deleteTicket_returnTrue()
    {

        //act
        List<TicketDTO> tickets = service.getAllTickets();
        var result = service.delete(tickets.get(0).getId());

        Assertions.assertEquals(result,true);

    }

    @Test
    public void deleteTicket_returnFalse()
    {

        //act
        List<TicketDTO> tickets = service.getAllTickets();
        var result = service.delete(tickets.get(2).getId());

        Assertions.assertEquals(result,false);

    }

    @Test
    public void addUserTest_returnTrue()
    {
        AppUser user = userDAL.getUserByID("1");
        Movie movie = movieDAL.getMovie("1");
        Projection projection = projectionDAL.getProjectionById("1");
        Room room = roomDAL.getRoomById("1");
        //act
        TicketDTO ticket = new TicketDTO("4",user.getId(),movie.getId(),projection.getId(),TicketType.CHILD,0,room.getId(),5);

        service.createTicket(ticket);

        ArgumentCaptor<Ticket> ticketArgumentCaptor = ArgumentCaptor.forClass(Ticket.class);

        verify(ticketDAL).create(ticketArgumentCaptor.capture());

        Ticket captorValue = ticketArgumentCaptor.getValue();

        Assertions.assertEquals(ticket.getId(), captorValue.getId());

    }

}