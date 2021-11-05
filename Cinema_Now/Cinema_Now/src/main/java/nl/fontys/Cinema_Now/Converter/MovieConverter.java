package nl.fontys.Cinema_Now.Converter;


import nl.fontys.Cinema_Now.DTO.MovieDTO;
import nl.fontys.Cinema_Now.Model.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieConverter {

    public MovieDTO entityToDto(Movie movie)
    {

        ModelMapper mapper = new ModelMapper();
        MovieDTO dto = mapper.map(movie,MovieDTO.class);

        return dto;

    }
    public List<MovieDTO> entityToDto(List<Movie> movies)
    {
        return movies.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }
    public Movie dtoToEntity(MovieDTO dto)
    {
        ModelMapper mapper = new ModelMapper();
        Movie entity = mapper.map(dto,Movie.class);


        return entity;

    }
    public List<Movie> dtoToEntity(List<MovieDTO> movieDTOS)
    {
        return movieDTOS.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());

    }

}
