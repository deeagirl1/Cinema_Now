package nl.fontys.Cinema_Now.repository;


import nl.fontys.Cinema_Now.dalInterfaces.ITicketDAL;
import nl.fontys.Cinema_Now.model.AppUser;
import nl.fontys.Cinema_Now.model.Ticket;
import nl.fontys.Cinema_Now.repoInterfaces.ITicketRepository;
import nl.fontys.Cinema_Now.repoInterfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import java.util.List;

@Repository @Transactional
public class TicketDALJPA implements ITicketDAL {


    private final ITicketRepository repo;
    private final IUserRepository userRepository;

    @Autowired
    public TicketDALJPA(ITicketRepository repo, IUserRepository userRepository)
    {
        this.repo = repo;
        this.userRepository = userRepository;
    }

    @Override
    public List<Ticket> getAllTickets() {
        return repo.findAll();
    }

    @Override
    public List<Ticket> getTicketsOfUser(String username) {
        AppUser user = userRepository.findByUsername(username);
        if(user != null)
        {
            return repo.findTicketsByHolder_Id(user.getId());

        }
       return null;
    }

    @Override
    public Ticket getTicketById(String id) {
        return repo.getById(id);
    }

    @Override
    public boolean create(Ticket ticket) {
        if (ticket != null) {
            repo.save(ticket);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (Ticket ticket : this.getAllTickets()) {
            if (ticket.getId().equals(id)) {
                repo.deleteById(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Ticket> getTicketsByMovieId(String movieId) {
        return repo.findTicketsByMovieId(movieId);
    }


}

