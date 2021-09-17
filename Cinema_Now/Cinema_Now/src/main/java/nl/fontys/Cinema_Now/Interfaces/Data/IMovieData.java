package nl.fontys.Cinema_Now.Interfaces.Data;

import nl.fontys.Cinema_Now.DTO.Enums.Format;
import nl.fontys.Cinema_Now.DTO.Enums.Genre;
import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.DTO.News;

import java.util.List;

public interface IMovieData {
    List<Movie> getAllMovies();
    Movie getMovie(int id);
    boolean addMovie(Movie movie);
    List<Movie> getMoviesBasedOnGenre(String genre);
    boolean editMovieDetails(Movie movie);
    boolean deleteMovie(int id);
}
