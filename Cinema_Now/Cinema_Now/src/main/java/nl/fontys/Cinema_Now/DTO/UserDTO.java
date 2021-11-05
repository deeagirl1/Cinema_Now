package nl.fontys.Cinema_Now.DTO;

import lombok.*;
import nl.fontys.Cinema_Now.Model.Enums.TicketType;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String email;
    private String firstName;
    private String lastName;

}
