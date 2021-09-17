package nl.fontys.Cinema_Now.Interfaces.Managers;

import nl.fontys.Cinema_Now.DTO.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> GetAllMovies();
    Movie GetMovie(int id);
    boolean AddMovie(Movie movie);
    List<Movie> GetMoviesBasedOnGenre(String genre);
    boolean editMovieDetails(Movie movie);
    boolean deleteMovie(int id);
}
