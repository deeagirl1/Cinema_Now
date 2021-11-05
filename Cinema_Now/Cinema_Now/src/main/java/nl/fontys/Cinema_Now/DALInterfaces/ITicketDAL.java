package nl.fontys.Cinema_Now.DALInterfaces;

import nl.fontys.Cinema_Now.Model.Ticket;
import java.util.List;


public interface ITicketDAL {
    List<Ticket> getAllTickets();
    Ticket getTicketByCode(String id);
    boolean create(Ticket ticket);
    boolean delete(String id);


}
