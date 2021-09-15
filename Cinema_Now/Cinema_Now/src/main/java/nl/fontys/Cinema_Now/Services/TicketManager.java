package nl.fontys.Cinema_Now.Services;

import nl.fontys.Cinema_Now.DTO.Ticket;
import nl.fontys.Cinema_Now.DTO.User;
import nl.fontys.Cinema_Now.Interfaces.Managers.ITicketManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class TicketManager implements ITicketManager {

        private Ticket ticket;
        private User user;

        @Autowired
        public TicketManager(Ticket ticket, User user)
        {
            this.ticket = ticket;
            this.user = user;
        }


    @Override
    public boolean buyTicket() {
        return false;
    }
}
