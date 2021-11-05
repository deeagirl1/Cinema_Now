package nl.fontys.Cinema_Now.ServiceInterface;

import nl.fontys.Cinema_Now.DTO.TicketDTO;
import java.util.List;


public interface ITicketService {
    boolean createTicket(TicketDTO ticket);
    List<TicketDTO> getAllTickets();
    TicketDTO getTicketByCode(String id);
    boolean delete(String id);
//    Ticket getTicketByUser(String user);
//    List<Ticket> getTicketsOfUser(Long userID);
//    double CalculateTotalTicketPrice(Ticket ticket);
}
