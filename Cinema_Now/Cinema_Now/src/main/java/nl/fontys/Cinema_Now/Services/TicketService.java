package nl.fontys.Cinema_Now.Services;

import nl.fontys.Cinema_Now.Modules.Ticket;
import nl.fontys.Cinema_Now.Interfaces.Data.ITicketData;
import nl.fontys.Cinema_Now.Interfaces.Services.ITicketService;
import nl.fontys.Cinema_Now.DTO.TicketDTO;
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
    public boolean createTicket(TicketDTO ticket) {

            if(ticket.getMovie() !=null)
            {
                data.Create(new TicketDTO(ticket.getType(),CalculateTotalTicketPrice(ticket),ticket.getDate(),ticket.getHolder(),ticket.getMovie()));

                return true;
            }

        return false;
    }

    @Override
    public double CalculateTotalTicketPrice(Ticket ticket) {
       List<Ticket> tickets = data.getAllTickets();
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

        double total = ticket.getPrice();

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

//    @Override
//    public Ticket getTicketByUser(String user) {
//        return data.getTicketByUser(user);
//    }
//
//    @Override
//    public List<Ticket> getTicketsOfUser(String user) {
//       return data.getTicketsOfUser(user);
//    }



}
