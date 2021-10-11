package nl.fontys.Cinema_Now.StorageTest;

import nl.fontys.Cinema_Now.DTO.TicketDTO;
import nl.fontys.Cinema_Now.Modules.Enums.Format;
import nl.fontys.Cinema_Now.Modules.Enums.Genre;
import nl.fontys.Cinema_Now.Modules.Enums.TicketType;
import nl.fontys.Cinema_Now.Modules.Movie;
import nl.fontys.Cinema_Now.Modules.Ticket;
import nl.fontys.Cinema_Now.Modules.User;
import nl.fontys.Cinema_Now.Repository.FakeDataMovies;
import nl.fontys.Cinema_Now.Repository.FakeDataTickets;
import nl.fontys.Cinema_Now.Services.MovieService;
import nl.fontys.Cinema_Now.Services.TicketService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketStorageTest {
    @Test
    public void createTicketTest()
    {
        TicketService data = new TicketService(new FakeDataTickets());
        User user1 = new User("Anna", "Johnsson","a.johnsson@gmail.com","Pastor Peterstraat",24);
        Movie movie1 = new Movie(1,("Cars"), Genre.ANIMATION,180,"06/06/2006","Test", Format._3D);
        TicketDTO ticket = new TicketDTO(TicketType.CHILD,3.99,"04/02/2021",user1.getFullName(),movie1.getName());
        var result = data.createTicket(ticket);

        Assertions.assertEquals(true,result);

    }

}
