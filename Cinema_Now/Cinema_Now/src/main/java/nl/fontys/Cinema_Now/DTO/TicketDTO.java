package nl.fontys.Cinema_Now.DTO;

import lombok.Getter;
import lombok.Setter;
import nl.fontys.Cinema_Now.Modules.Enums.TicketType;
import nl.fontys.Cinema_Now.Modules.Ticket;

public class TicketDTO extends Ticket {
    private @Getter @Setter String movie;
    private @Getter @Setter String holder;

    public TicketDTO(TicketType type, double price, String date, String holder, String movie) {
        super(type,price,date);
        this.movie = movie;
        this.holder = holder;
    }

}
