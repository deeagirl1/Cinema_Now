package nl.fontys.Cinema_Now.DTO;

import lombok.*;
import nl.fontys.Cinema_Now.Model.Complaint;

import java.util.Date;
import java.util.UUID;

@Data @AllArgsConstructor @NoArgsConstructor
public class ComplaintDTO {

    private @Getter @Setter String sender_id;
    private @Getter @Setter String container;
    private @Getter @Setter String title;
    private @Getter @Setter String sentDate;
}
