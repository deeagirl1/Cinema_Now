package nl.fontys.Cinema_Now.DALInterfaces;

import nl.fontys.Cinema_Now.Model.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieDAL {
    Movie getMovie(String id);
    List<Movie> getMoviesBasedOnGenre(String genre);
    List<Movie> getAllMovies();
    boolean addMovie(Movie movie);
    boolean editMovie(Movie movie);
    boolean deleteMovie(String id);
}
