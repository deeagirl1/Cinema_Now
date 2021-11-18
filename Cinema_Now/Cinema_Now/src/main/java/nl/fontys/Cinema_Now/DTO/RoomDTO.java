package nl.fontys.Cinema_Now.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.fontys.Cinema_Now.Model.Ticket;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    private String roomName;
    private int capacity;
    private String movie_id;
    private List<Ticket> nrOfTicket;
}
