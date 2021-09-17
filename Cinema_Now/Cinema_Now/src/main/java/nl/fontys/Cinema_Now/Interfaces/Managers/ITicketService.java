package nl.fontys.Cinema_Now.Interfaces.Managers;

import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.DTO.User;

public interface ITicketService {
    boolean buyTicket(User user, Movie movie);
    void GenerateQRCode();
}
