package nl.fontys.Cinema_Now.dto;

import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ComplaintDTO {

    private String id;
    private String container;
    private String sender;
    private String title;
    private String sentDate;
}
