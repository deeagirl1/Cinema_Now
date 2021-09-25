package nl.fontys.Cinema_Now.Repository;

import nl.fontys.Cinema_Now.DTO.Enums.Format;
import nl.fontys.Cinema_Now.DTO.Enums.Genre;
import nl.fontys.Cinema_Now.DTO.Enums.TicketType;
import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.DTO.News;
import nl.fontys.Cinema_Now.DTO.Ticket;
import nl.fontys.Cinema_Now.DTO.User;
import nl.fontys.Cinema_Now.Interfaces.Data.ITicketData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class FakeDataTickets implements ITicketData {
    private final List<Ticket> ticketsList = new ArrayList<>();
    public FakeDataTickets()
    {
        User user1 = new User("Anna", "Johnsson");
        Movie avengers = new Movie("Avengers");
        Ticket ticket1 = new Ticket(user1, avengers, TicketType.ADULT, new int[]{6, 3, 4},"231",8.99);
        user1.getTicketList().add(ticket1.getTicketID());
        ticketsList.add(ticket1);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketsList;
    }

    @Override
    public Ticket getTicketByCode(int id) {
        for (Ticket ticket : ticketsList)
        {
            if(ticket.getTicketID() == id)
            {
                return ticket;
            }
        }
        return null;
    }

    @Override
    public Ticket getTicketByUser(String user) {
        for (Ticket ticket : ticketsList)
        {
            if(user == ticket.getHolder().getLastName().toLowerCase(Locale.ROOT))
            {
                return ticket;
            }
        }
        return  null;
    }

    @Override
    public List<Ticket> getTicketsOfUser(String user) {
        List<Ticket> temp = null;
        for (Ticket ticket : ticketsList)
        {
            if(user == ticket.getHolder().getLastName().toLowerCase(Locale.ROOT))
                temp.add(ticket);
        }
        return temp;
    }
}
