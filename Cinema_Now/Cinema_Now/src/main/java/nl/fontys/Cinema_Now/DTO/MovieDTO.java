package nl.fontys.Cinema_Now.DTO;


import lombok.*;
import nl.fontys.Cinema_Now.Model.Enums.Format;
import nl.fontys.Cinema_Now.Model.Enums.Genre;

import javax.persistence.Column;

@Data
@AllArgsConstructor @NoArgsConstructor
public class MovieDTO {

    private @Getter @Setter String name;
    private @Getter @Setter Genre genre;
    private @Getter @Setter int duration;
    private @Getter @Setter String releaseDate;
    private @Getter @Setter String description;
    private @Getter @Setter Format format;
    private @Getter @Setter String director;
}
