package nl.fontys.Cinema_Now.Repository;

import nl.fontys.Cinema_Now.DALInterfaces.IMovieDAL;
import nl.fontys.Cinema_Now.Model.Movie;
import nl.fontys.Cinema_Now.RepoInterfaces.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieDALJPA implements IMovieDAL {

    @Autowired
    IMovieRepository repo;

    @Override
    public Movie getMovie(String id) {
        return repo.findById(id).get();
    }


    @Override
    public List<Movie> getAllMovies() {
        return repo.findAll();
    }


    @Override
    public List<Movie> getMoviesBasedOnGenre(String genre) {
        return (List<Movie>) repo.getMovieByGenre(genre);
    }

    @Override
    public boolean addMovie(Movie movie) {
        repo.save(movie);
        return  true;
    }

    @Override
    public boolean editMovie(Movie movie) {
        repo.save(movie);
        return true;
    }

    @Override
    public boolean deleteMovie(String id) {
         repo.deleteById(id);
         return true;

    }
}
