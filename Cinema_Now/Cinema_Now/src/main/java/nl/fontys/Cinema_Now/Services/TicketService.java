package nl.fontys.Cinema_Now.Services;

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
    public boolean buyTicket() {
        return false;
    }
}
