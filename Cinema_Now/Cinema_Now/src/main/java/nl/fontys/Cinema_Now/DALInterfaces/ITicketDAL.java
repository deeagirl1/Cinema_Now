package nl.fontys.Cinema_Now.DALInterfaces;

import nl.fontys.Cinema_Now.Model.Ticket;
import nl.fontys.Cinema_Now.DTO.TicketDTO;

import java.util.List;
import java.util.UUID;

public interface ITicketDAL {
    List<Ticket> getAllTickets();
    Ticket getTicketByCode(String id);
    boolean create(Ticket ticket);
    boolean delete(String id);
//    boolean Update(Long id, Ticket ticket);
//    List<Ticket> getTicketsOfUser(Long userID);

}
