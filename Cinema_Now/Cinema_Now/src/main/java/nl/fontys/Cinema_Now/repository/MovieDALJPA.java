package nl.fontys.Cinema_Now.repository;

import nl.fontys.Cinema_Now.dalInterfaces.IMovieDAL;
import nl.fontys.Cinema_Now.model.Movie;
import nl.fontys.Cinema_Now.repoInterfaces.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Repository @Transactional
public class MovieDALJPA implements IMovieDAL {

    private final IMovieRepository repo;

    @Autowired
    public MovieDALJPA(IMovieRepository repo)
    {
        this.repo = repo;
    }

    @Override
    public Movie getMovie(String id) {
        return repo.getById(id);
    }

    @Override
    public List<Movie> getAllMovies() {
        return repo.findAll();
    }


    @Override
    public List<Movie> getMoviesBasedOnGenre(String genre) {
        return repo.findMoviesByGenre(genre);
    }

    @Override
    public boolean addMovie(Movie movie) {
        if(movie!= null) {
            repo.save(movie);
            return true;
        }
        return false;
    }

    @Override
    public boolean editMovie(Movie movie) {
        if(movie!= null) {
            repo.save(movie);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteMovie(String id) {
        if(this.getMovie(id) != null) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Movie> getMoviesByProjectionDate(String date) {
        return repo.getMoviesByProjections(date);
    }


}
