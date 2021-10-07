package nl.fontys.Cinema_Now.Interfaces.Services;

import nl.fontys.Cinema_Now.Modules.Ticket;
import nl.fontys.Cinema_Now.DTO.TicketDTO;

import java.util.List;

public interface ITicketService {
    boolean createTicket(TicketDTO ticket);
    void GenerateQRCode();
    List<Ticket> getAllTickets();
    Ticket getTicketByCode(int id);
//    Ticket getTicketByUser(String user);
//    List<Ticket> getTicketsOfUser(String user);
    double CalculateTotalTicketPrice(Ticket ticket);
}
