package nl.fontys.Cinema_Now.Interfaces.Data;

import nl.fontys.Cinema_Now.DTO.Ticket;
import nl.fontys.Cinema_Now.DTO.User;

import java.util.List;

public interface ITicketData {
    List<Ticket> getAllTickets();
    Ticket getTicketByCode(int id);
    Ticket getTicketByUser(String user);
    List<Ticket> getTicketsOfUser(String user);
}
