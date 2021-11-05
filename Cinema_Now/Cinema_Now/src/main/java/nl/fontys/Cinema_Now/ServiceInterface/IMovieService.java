package nl.fontys.Cinema_Now.ServiceInterface;

import nl.fontys.Cinema_Now.DTO.MovieDTO;
import nl.fontys.Cinema_Now.Model.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieService {
    List<Movie> getAllMovies();
    Movie getMovie(String id);
    boolean addMovie(MovieDTO movie);
    List<Movie> getMoviesBasedOnGenre(String genre);
    boolean editMovieDetails(MovieDTO movie);
    boolean deleteMovie(String id);
}
