package nl.fontys.Cinema_Now.dto;

import lombok.*;
import nl.fontys.Cinema_Now.model.Enums.TicketType;

@Data @NoArgsConstructor @AllArgsConstructor
public class TicketDTO{

    private String id;
    private String holderId;
    private String movieId;
    private String projectionId;
    private TicketType type;
    private double price;
    private String roomName;
    private int amountOfPeople;

}
