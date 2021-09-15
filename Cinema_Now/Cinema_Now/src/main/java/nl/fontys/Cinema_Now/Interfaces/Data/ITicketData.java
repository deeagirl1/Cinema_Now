package nl.fontys.Cinema_Now.Interfaces.Data;

import nl.fontys.Cinema_Now.DTO.Ticket;
import nl.fontys.Cinema_Now.DTO.User;

import java.util.List;

public interface ITicketData {
    List<Ticket> GetAllTickets();
    Ticket GetTicketByCode(int id);
    Ticket GetTicketByUser(User user);
}
