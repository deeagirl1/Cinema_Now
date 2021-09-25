package nl.fontys.Cinema_Now.Services;

import nl.fontys.Cinema_Now.DTO.Enums.TicketType;
import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.DTO.Ticket;
import nl.fontys.Cinema_Now.DTO.User;
import nl.fontys.Cinema_Now.Interfaces.Data.ITicketData;
import nl.fontys.Cinema_Now.Interfaces.Managers.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService {

        private ITicketData data;
   @Autowired
   public TicketService(ITicketData data)
        {
            this.data = data;
        }


    @Override
    public boolean createTicket(Ticket ticket) {

            if(ticket.getHolder()!=null && ticket.getMovie() !=null)
            {

                ticket.getHolder().getTicketList().add(ticket.getTicketID());
                return true;
            }

        return false;
    }

    @Override
    public double CalculateTotalTicketPrice(Ticket ticket) {
        switch(ticket.getType()) {
            case ADULT:
                ticket.setPrice(6.99);
                break;
            case CHILD:
                ticket.setPrice(3.99);
                break;
            case RETIRED:
            case STUDENT:
                ticket.setPrice(4.99);
                break;
        }

        double total = ticket.getPrice() * ticket.getNrSeats().length;

        return total;
    }

    @Override
    public void GenerateQRCode() {

    }

    @Override
    public List<Ticket> getAllTickets()
    {
        return this.data.getAllTickets();
    }

    @Override
    public Ticket getTicketByCode(int id) {
        return data.getTicketByCode(id);
    }

    @Override
    public Ticket getTicketByUser(String user) {
        return data.getTicketByUser(user);
    }

    @Override
    public List<Ticket> getTicketsOfUser(String user) {
       return data.getTicketsOfUser(user);
    }



}
