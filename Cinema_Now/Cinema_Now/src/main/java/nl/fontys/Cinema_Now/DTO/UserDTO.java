package nl.fontys.Cinema_Now.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

}
