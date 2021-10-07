package nl.fontys.Cinema_Now.Services;

import nl.fontys.Cinema_Now.Modules.Movie;
import nl.fontys.Cinema_Now.Interfaces.Data.IMovieData;
import nl.fontys.Cinema_Now.Interfaces.Services.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    private IMovieData movieData;

    @Autowired
    public MovieService(IMovieData movieData)
    {
        this.movieData = movieData;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieData.getAllMovies();
    }

    @Override
    public Movie getMovie(int id) {
        return movieData.getMovie(id);
    }

    @Override
    public boolean addMovie(Movie movie) {
        return movieData.addMovie(movie);
    }

    @Override
    public List<Movie> getMoviesBasedOnGenre(String genre) {
        return movieData.getMoviesBasedOnGenre(genre);
    }


    @Override
    public boolean editMovieDetails(Movie movie) {
        return movieData.editMovieDetails(movie);

    }

    @Override
    public boolean deleteMovie(int id) {
        return movieData.deleteMovie(id);
    }
}


