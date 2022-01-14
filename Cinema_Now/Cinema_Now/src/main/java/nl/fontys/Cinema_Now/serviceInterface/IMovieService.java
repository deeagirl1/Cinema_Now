package nl.fontys.Cinema_Now.serviceInterface;

import nl.fontys.Cinema_Now.dto.MovieDTO;
import nl.fontys.Cinema_Now.model.Enums.Format;
import nl.fontys.Cinema_Now.model.Enums.Genre;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface IMovieService {
    List<MovieDTO> getAllMovies();
    MovieDTO getMovie(String id);
    boolean addMovie(MovieDTO movie, MultipartFile file) throws IOException;
    List<MovieDTO> getMoviesBasedOnGenre(String genre);
    boolean editMovieDetails(MovieDTO movie);
    boolean deleteMovie(String id);
    List<Genre> getAllGenres();
    List<Format> getAllFormats();
    List<MovieDTO> getMoviesByProjectionDate(String date);
}
