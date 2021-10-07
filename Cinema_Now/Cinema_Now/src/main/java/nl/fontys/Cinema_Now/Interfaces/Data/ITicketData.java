package nl.fontys.Cinema_Now.Interfaces.Data;

import nl.fontys.Cinema_Now.Modules.Ticket;
import nl.fontys.Cinema_Now.DTO.TicketDTO;

import java.util.List;

public interface ITicketData {
    List<Ticket> getAllTickets();
    Ticket getTicketByCode(int id);
    boolean Create(TicketDTO ticket);

}
