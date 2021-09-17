package nl.fontys.Cinema_Now.Interfaces.Data;

import nl.fontys.Cinema_Now.DTO.Enums.Format;
import nl.fontys.Cinema_Now.DTO.Enums.Genre;
import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.DTO.News;

import java.util.List;

public interface IMovieData {
    List<Movie> GetAllMovies();
    Movie GetMovie(int id);
    boolean AddMovie(Movie movie);
    List<Movie> GetMoviesBasedOnGenre(String genre);
    boolean editMovieDetails(Movie movie);
    boolean deleteMovie(int id);
}
