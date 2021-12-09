package nl.fontys.Cinema_Now.dto;

import lombok.*;
import nl.fontys.Cinema_Now.model.Enums.Format;
import nl.fontys.Cinema_Now.model.Enums.Genre;

import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor @NoArgsConstructor
public class MovieDTO {

    private String id;
    private String name;
    private Genre genre;
    private int duration;
    private String releaseDate;
    private String description;
    private Format format;
    private String director;
    private String roomId;
    private Collection<ProjectionDTO> projections = new ArrayList<>();



}
