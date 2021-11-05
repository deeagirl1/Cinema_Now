package nl.fontys.Cinema_Now.RepoInterfaces;


import nl.fontys.Cinema_Now.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ITicketRepository extends JpaRepository<Ticket, String> {
}
