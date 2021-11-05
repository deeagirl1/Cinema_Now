package nl.fontys.Cinema_Now.DTO;

import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
public class ComplaintDTO {

    private  String sender_id;
    private  String container;
    private  String title;
    private  String sentDate;
}
