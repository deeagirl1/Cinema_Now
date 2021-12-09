package nl.fontys.Cinema_Now.dto;

import lombok.*;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String email;
    private boolean isLoyal;
    private Collection<String> tickets;
    private Collection<String> complaints;

}
