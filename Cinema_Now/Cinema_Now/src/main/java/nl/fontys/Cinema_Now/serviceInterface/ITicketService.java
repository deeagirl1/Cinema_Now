package nl.fontys.Cinema_Now.serviceInterface;

import nl.fontys.Cinema_Now.dto.TicketDTO;
import nl.fontys.Cinema_Now.model.Enums.TicketType;

import java.util.List;


public interface ITicketService {
    boolean createTicket(TicketDTO ticket);
    List<TicketDTO> getAllTickets();
    List<TicketType> getAllTypes();
    List<TicketDTO> getTicketsOfUser(String username);
    TicketDTO getTicketById(String id);
    boolean delete(String id);
    List<TicketDTO> getTicketsByMovieId(String movieId);

}
