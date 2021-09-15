package nl.fontys.Cinema_Now.Services;

import nl.fontys.Cinema_Now.DTO.Ticket;
import nl.fontys.Cinema_Now.DTO.User;
import nl.fontys.Cinema_Now.Interfaces.Data.ITicketData;
import nl.fontys.Cinema_Now.Interfaces.Managers.ITicketManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class TicketManager implements ITicketManager {

        private ITicketData data;

        @Autowired
        public TicketManager(ITicketData data)
        {
            this.data = data;
        }


    @Override
    public boolean buyTicket() {
        return false;
    }
}
