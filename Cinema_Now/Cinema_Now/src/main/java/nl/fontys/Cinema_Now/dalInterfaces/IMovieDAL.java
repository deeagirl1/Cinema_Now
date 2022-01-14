package nl.fontys.Cinema_Now.dalInterfaces;

import nl.fontys.Cinema_Now.model.Movie;

import java.util.List;

public interface IMovieDAL {
    Movie getMovie(String id);
    List<Movie> getMoviesBasedOnGenre(String genre);
    List<Movie> getAllMovies();
    boolean addMovie(Movie movie);
    boolean editMovie(Movie movie);
    boolean editMovieWithoutPicture(Movie movie);
    boolean deleteMovie(String id);
    List<Movie> getMoviesByProjectionDate(String date);

}
