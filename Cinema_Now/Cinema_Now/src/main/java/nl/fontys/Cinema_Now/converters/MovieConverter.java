package nl.fontys.Cinema_Now.converters;


import nl.fontys.Cinema_Now.dto.MovieDTO;
import nl.fontys.Cinema_Now.dto.ProjectionDTO;
import nl.fontys.Cinema_Now.model.Movie;
import nl.fontys.Cinema_Now.model.Projection;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieConverter {

    private final ProjectionConverter projectionConverter = new ProjectionConverter();

    public MovieDTO entityToDto(Movie movie)
    {

        MovieDTO dto  = new MovieDTO();
        dto.setId(movie.getId());
        dto.setRoomId(movie.getRoom().getId());
        dto.setName(movie.getName());
        dto.setDuration(movie.getDuration());
        dto.setDirector(movie.getDirector());
        dto.setDescription(movie.getDescription());
        dto.setFormat(movie.getFormat());
        dto.setReleaseDate(movie.getReleaseDate());
        dto.setGenre(movie.getGenre());
        for (Projection projection: movie.getProjections()
             ) {
            dto.getProjections().add(projectionConverter.entityToDto(projection));
        }

        return dto;

    }
    public List<MovieDTO> entityToDto(List<Movie> movies)
    {
        return movies.stream().map(this::entityToDto).collect(Collectors.toList());

    }
    public Movie dtoToEntity(MovieDTO dto)
    {
        Movie entity = new Movie();

        entity.setDescription(dto.getDescription());
        entity.setDirector(dto.getDirector());
        entity.setDuration(dto.getDuration());
        entity.setFormat(dto.getFormat());
        entity.setGenre(dto.getGenre());
        entity.setId(dto.getId());
        entity.setReleaseDate(dto.getReleaseDate());
        entity.setName(dto.getName());
        entity.setReleaseDate(dto.getReleaseDate());

        for (ProjectionDTO projection: dto.getProjections()
        ) {
            entity.getProjections().add(projectionConverter.dtoToEntity(projection));
        }


        return entity;

    }
    public List<Movie> dtoToEntity(List<MovieDTO> movieDTOS)
    {
        return movieDTOS.stream().map(this::dtoToEntity).collect(Collectors.toList());

    }

}
