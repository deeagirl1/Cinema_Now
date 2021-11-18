package nl.fontys.Cinema_Now.DTO;

import lombok.*;
import nl.fontys.Cinema_Now.Model.Enums.TicketType;

@Data @NoArgsConstructor @AllArgsConstructor
public class TicketDTO{

    private String holder_id;
    private String movie_id;
    private String date;
    private TicketType type;
    private double price;
    private String room_id;
    private int amountOfPeople;

}
