package nl.fontys.Cinema_Now.Interfaces.Managers;

import nl.fontys.Cinema_Now.DTO.Enums.TicketType;
import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.DTO.Ticket;
import nl.fontys.Cinema_Now.DTO.User;

import java.util.List;

public interface ITicketService {
    boolean createTicket(Ticket ticket);
    void GenerateQRCode();
    List<Ticket> getAllTickets();
    Ticket getTicketByCode(int id);
    Ticket getTicketByUser(String user);
    List<Ticket> getTicketsOfUser(String user);
    double CalculateTotalTicketPrice(Ticket ticket);
}
