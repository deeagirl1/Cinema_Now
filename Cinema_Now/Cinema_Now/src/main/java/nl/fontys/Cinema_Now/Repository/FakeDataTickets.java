package nl.fontys.Cinema_Now.Repository;

import nl.fontys.Cinema_Now.Modules.Enums.TicketType;
import nl.fontys.Cinema_Now.Modules.Movie;
import nl.fontys.Cinema_Now.Modules.Ticket;
import nl.fontys.Cinema_Now.Modules.User;
import nl.fontys.Cinema_Now.Interfaces.Data.ITicketData;
import nl.fontys.Cinema_Now.DTO.TicketDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class FakeDataTickets implements ITicketData {
    private final List<Ticket> ticketsList = new ArrayList<>();

    public FakeDataTickets()
    {
        User user1 = new User("Anna", "Johnsson","anna.j@gmail.com");
        Movie movie = new Movie("Avengers");
        TicketDTO ticket = new TicketDTO(TicketType.ADULT, 6.99,"02/10/2021",user1.getFullName(),movie.getName());
        user1.getTicketList().add(ticket.getTicketID());
        ticketsList.add(ticket);
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
    public boolean Create(TicketDTO ticket) {

        if (this.getTicketByCode(ticket.getTicketID()) != null) {
            return false;
        }
        ticketsList.add((ticket));
        return true;
    }

//    @Override
//    public Ticket getTicketByUser(String user) {
//        for (Ticket ticket : ticketsList)
//        {
//            if(user == ticket.getHolder().getLastName().toLowerCase(Locale.ROOT))
//            {
//                return ticket;
//            }
//        }
//        return  null;
//    }
//
//    @Override
//    public List<Ticket> getTicketsOfUser(String user) {
//        List<Ticket> temp = null;
//        for (Ticket ticket : ticketsList)
//        {
//            if(user == ticket.getHolder().getLastName().toLowerCase(Locale.ROOT))
//                temp.add(ticket);
//        }
//        return temp;
//    }
}
