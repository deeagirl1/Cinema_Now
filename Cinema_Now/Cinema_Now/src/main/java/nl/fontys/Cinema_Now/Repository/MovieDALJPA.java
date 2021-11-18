package nl.fontys.Cinema_Now.Repository;

import nl.fontys.Cinema_Now.DALInterfaces.IMovieDAL;
import nl.fontys.Cinema_Now.Model.AppUser;
import nl.fontys.Cinema_Now.Model.Movie;
import nl.fontys.Cinema_Now.RepoInterfaces.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Repository @Transactional
public class MovieDALJPA implements IMovieDAL {

    @Autowired
    IMovieRepository repo;
    public MovieDALJPA(IMovieRepository repo)
    {
        this.repo = repo;
    }

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
        Movie updatedMovie = this.getMovie(movie.getId());
        updatedMovie.setName(movie.getName());
        updatedMovie.setGenre(movie.getGenre());
        updatedMovie.setDescription(movie.getDescription());
        updatedMovie.setFormat(movie.getFormat());
        updatedMovie.setDuration(movie.getDuration());
        updatedMovie.setDirector(movie.getDirector());
        updatedMovie.setReleaseDate(movie.getReleaseDate());
        repo.save(movie);
        return true;
    }

    @Override
    public boolean deleteMovie(String id) {
         repo.deleteById(id);
         return true;

    }
}
