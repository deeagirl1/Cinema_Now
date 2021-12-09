package nl.fontys.Cinema_Now.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    private String id;
    private String name;
    private int capacity;

}
