package nl.fontys.Cinema_Now.Repository;


import nl.fontys.Cinema_Now.DALInterfaces.ITicketDAL;
import nl.fontys.Cinema_Now.Model.Ticket;
import nl.fontys.Cinema_Now.RepoInterfaces.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketDALJPA implements ITicketDAL {

    @Autowired
    ITicketRepository repo;


    @Override
    public List<Ticket> getAllTickets() {
        return repo.findAll();
    }

    @Override
    public Ticket getTicketByCode(String id) {
        return repo.findById(id).get();
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
        for (Ticket ticket : repo.findAll()) {
            if (ticket.getId().equals(id)) {
                repo.deleteById(id);
                return true;
            }
        }
        return false;
    }


//    @Override
//    public boolean Update(Long id, Ticket ticket) {
//
//        if(ticket != null) {
////            TicketCalculator calculator = new TicketCalculator(ticket);
////            ticket.setPrice(calculator.CalculateTotalTicketPrice());
//
//            repo.save(ticket);
//            return true;
//        }
//        return false;
//    }

//    @Override
//    public List<Ticket> getTicketsOfUser(Long userID) {
//        List<Ticket> tickets = repo.findAllById(userRepo.findById(userID));
//    }
}

