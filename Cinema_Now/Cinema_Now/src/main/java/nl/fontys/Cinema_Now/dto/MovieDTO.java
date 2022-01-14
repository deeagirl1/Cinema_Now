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
    private String movieImage;

    public MovieDTO(String name, Genre genre, int duration, String releaseDate, String description, Format format, String director, String roomId, Collection<ProjectionDTO> projections) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.description = description;
        this.format = format;
        this.director = director;
        this.roomId = roomId;
        this.projections = projections;
    }

    public MovieDTO(String id, String name, Genre genre, int duration, String releaseDate, String description, Format format, String director, String roomId, Collection<ProjectionDTO> projections) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.description = description;
        this.format = format;
        this.director = director;
        this.roomId = roomId;
        this.projections = projections;
    }

    public MovieDTO(String name, Genre genre, int duration, String releaseDate, String description, Format format, String director, String roomId) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.description = description;
        this.format = format;
        this.director = director;
        this.roomId = roomId;
    }
}
