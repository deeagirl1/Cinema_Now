package nl.fontys.Cinema_Now.Service;

import nl.fontys.Cinema_Now.Converter.MovieConverter;
import nl.fontys.Cinema_Now.DALInterfaces.IMovieDAL;
import nl.fontys.Cinema_Now.DTO.MovieDTO;
import nl.fontys.Cinema_Now.Model.Movie;
import nl.fontys.Cinema_Now.ServiceInterface.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MovieService implements IMovieService {

    private IMovieDAL dal;
    private MovieConverter converter;

    @Autowired
    public MovieService(IMovieDAL dal, MovieConverter converter) {

        this.dal = dal;
        this.converter = converter;
    }

    @Override
    public List<Movie> getAllMovies() {
        return dal.getAllMovies();
    }

    @Override
    public Movie getMovie(String id) {
        return dal.getMovie(id);
    }

    @Override
    public boolean addMovie(MovieDTO movie) {
        if(movie != null)
        {
            Movie entity = converter.dtoToEntity(movie);
            dal.addMovie(entity);
            return true;
        }
        return false;
    }

    @Override
    public List<Movie> getMoviesBasedOnGenre(String genre) {

        List<Movie> temp = new ArrayList<>();
        for (Movie movie : this.getAllMovies()) {
            if (genre.contains(movie.getGenre().toString().toLowerCase(Locale.ROOT))) {
                temp.add(movie);
            }
        }
        return temp;

    }


    @Override
    public boolean editMovieDetails(MovieDTO movie) {
        return dal.editMovie(converter.dtoToEntity(movie));

    }

    @Override
    public boolean deleteMovie(String id) {
        return dal.deleteMovie(id);
    }
}


