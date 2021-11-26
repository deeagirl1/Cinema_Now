package nl.fontys.Cinema_Now.DTO;

import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ComplaintDTO {
    
    private String container;
    private String sender;
    private String title;
    private String sentDate;
}
