package nl.fontys.Cinema_Now.repoInterfaces;

import nl.fontys.Cinema_Now.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ITicketRepository extends JpaRepository<Ticket, String> {
    List<Ticket> findTicketsByHolder_Id(String username);
    List<Ticket> findTicketsByMovieId(String movieId);

}
