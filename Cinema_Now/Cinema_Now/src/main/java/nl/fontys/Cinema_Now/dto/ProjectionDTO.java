package nl.fontys.Cinema_Now.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectionDTO {

    private String id;
    private String time;
    private String date;

}
