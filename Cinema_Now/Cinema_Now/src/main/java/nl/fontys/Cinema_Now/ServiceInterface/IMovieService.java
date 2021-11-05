package nl.fontys.Cinema_Now.ServiceInterface;

import nl.fontys.Cinema_Now.Model.Movie;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IMovieService {
    List<Movie> getAllMovies();
    Movie getMovie(String id);
    void addMovie(Movie movie);
    List<Movie> getMoviesBasedOnGenre(String genre);
    boolean editMovieDetails(Movie movie);
    boolean deleteMovie(String id);
}
