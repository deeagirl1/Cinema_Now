package nl.fontys.Cinema_Now.ServiceInterface;

import nl.fontys.Cinema_Now.DTO.TicketDTO;
import java.util.List;


public interface ITicketService {
    boolean createTicket(TicketDTO ticket);
    List<TicketDTO> getAllTickets();
    TicketDTO getTicketByCode(String id);
    boolean delete(String id);

}
