package nl.fontys.Cinema_Now.Services;

import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.Interfaces.Data.IMovieData;
import nl.fontys.Cinema_Now.Interfaces.Managers.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Movie> GetAllMovies() {
        return movieData.GetAllMovies();
    }

    @Override
    public Movie GetMovie(int id) {
        return movieData.GetMovie(id);
    }

    @Override
    public boolean AddMovie(Movie movie) {
        return movieData.AddMovie(movie);
    }

    @Override
    public List<Movie> GetMoviesBasedOnGenre(String genre) {
        return movieData.GetMoviesBasedOnGenre(genre);
    }


    @Override
    public boolean editMovieDetails(Movie movie) {
        return movieData.editMovieDetails(movie);

    }

    @Override
    public boolean deleteMovie(int id) {
        return false;
    }
}


