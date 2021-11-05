package nl.fontys.Cinema_Now.DTO;


import lombok.*;
import nl.fontys.Cinema_Now.Model.Enums.Format;
import nl.fontys.Cinema_Now.Model.Enums.Genre;


@Data
@AllArgsConstructor @NoArgsConstructor
public class MovieDTO {

    private String name;
    private Genre genre;
    private int duration;
    private String releaseDate;
    private String description;
    private Format format;
    private String director;
}
