package nl.fontys.Cinema_Now.repository;

import nl.fontys.Cinema_Now.dalInterfaces.IMovieDAL;
import nl.fontys.Cinema_Now.dto.ProjectionDTO;
import nl.fontys.Cinema_Now.model.Enums.Format;
import nl.fontys.Cinema_Now.model.Enums.Genre;
import nl.fontys.Cinema_Now.model.Movie;
import nl.fontys.Cinema_Now.model.Projection;
import nl.fontys.Cinema_Now.model.Room;
import nl.fontys.Cinema_Now.repoInterfaces.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

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
    public boolean editMovieWithoutPicture(Movie movie) {
        if(movie!= null)
        {
            Collection<String> projectionIds = new ArrayList<>();
            for (Projection proj: movie.getProjections()
            ) {
                projectionIds.add(proj.getId());
            }
            repo.updateMovieWithoutImage(
                    movie.getDescription(),
                    movie.getDirector(),
                    movie.getDuration(),
                    movie.getFormat().ordinal(),
                    movie.getGenre().ordinal(),
                    movie.getName(),
                    movie.getReleaseDate(),
                    movie.getRoom(),
                    projectionIds,
                    movie.getId());
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
