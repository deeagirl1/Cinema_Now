package nl.fontys.Cinema_Now.DTO;

import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor
public class MovieDTO {

    private String name;
    private String genre;
    private int duration;
    private String releaseDate;
    private String description;
    private String format;
    private String director;

}
