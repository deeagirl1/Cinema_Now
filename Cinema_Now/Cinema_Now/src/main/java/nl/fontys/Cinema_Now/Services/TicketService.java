package nl.fontys.Cinema_Now.Services;

import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.DTO.Ticket;
import nl.fontys.Cinema_Now.DTO.User;
import nl.fontys.Cinema_Now.Interfaces.Data.ITicketData;
import nl.fontys.Cinema_Now.Interfaces.Managers.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;

public class TicketService implements ITicketService {

        private ITicketData data;

        @Autowired
        public TicketService(ITicketData data)
        {
            this.data = data;
        }


    @Override
    public boolean buyTicket(User user, Movie movie) {


        return false;
    }

    @Override
    public void GenerateQRCode() {

    }
}
