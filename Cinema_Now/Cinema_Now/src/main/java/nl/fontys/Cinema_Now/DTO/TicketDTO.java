package nl.fontys.Cinema_Now.DTO;

import lombok.*;
import nl.fontys.Cinema_Now.Model.Enums.TicketType;
import nl.fontys.Cinema_Now.Model.Movie;
import nl.fontys.Cinema_Now.Model.Ticket;
import nl.fontys.Cinema_Now.Model.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Data @NoArgsConstructor @AllArgsConstructor
public class TicketDTO{

    private @Getter @Setter String holder_id;
    private @Getter @Setter String movie_id;
    private @Getter @Setter String date;
    private @Getter @Setter TicketType type;
    private @Getter @Setter double price;






}
