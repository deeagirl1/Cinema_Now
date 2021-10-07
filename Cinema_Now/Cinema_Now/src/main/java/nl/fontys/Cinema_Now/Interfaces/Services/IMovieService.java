package nl.fontys.Cinema_Now.Interfaces.Services;

import nl.fontys.Cinema_Now.Modules.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> getAllMovies();
    Movie getMovie(int id);
    boolean addMovie(Movie movie);
    List<Movie> getMoviesBasedOnGenre(String genre);
    boolean editMovieDetails(Movie movie);
    boolean deleteMovie(int id);
}
