package nl.fontys.Cinema_Now.dalInterfaces;

import nl.fontys.Cinema_Now.model.Ticket;
import java.util.List;


public interface ITicketDAL {
    List<Ticket> getAllTickets();
    List<Ticket> getTicketsOfUser(String username);
    Ticket getTicketById(String id);
    boolean create(Ticket ticket);
    boolean delete(String id);
    List<Ticket> getTicketsByMovieId(String movieId);


}
