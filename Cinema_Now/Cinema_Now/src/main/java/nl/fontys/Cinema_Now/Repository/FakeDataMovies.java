package nl.fontys.Cinema_Now.Repository;
import nl.fontys.Cinema_Now.DTO.Enums.Format;
import nl.fontys.Cinema_Now.DTO.Enums.Genre;
import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.DTO.News;
import nl.fontys.Cinema_Now.Interfaces.Data.IMovieData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class FakeDataMovies implements IMovieData {

    private final List<Movie> movies = new ArrayList<>();

    @Autowired
    public FakeDataMovies() {

        Movie avengers = new Movie(2,"Avengers", Genre.ACTION, 180, "05/05/2012", "Earth's mightiest heroes are shown a difficult task to save New York from Loki.", Format._4DX);

        movies.add(avengers);

    }

    @Override
    public List<Movie> getAllMovies() {
        return movies;
    }

    @Override
    public Movie getMovie(int id) {
        for (Movie movie : movies) {
            if (movie.getID() == id) {
                return movie;
            }
        }
        return null;
    }

    @Override
    public boolean addMovie(Movie movie) {
        if (this.getMovie(movie.getID()) != null) {
            return false;
        }
        movies.add((movie));
        return true;
    }

    @Override
    public List<Movie> getMoviesBasedOnGenre(String genre) {
        List<Movie> temp = new ArrayList<>();
        for (Movie movie : movies) {
            if (genre.contains(movie.getGenre().toString().toLowerCase(Locale.ROOT))) {
                temp.add(movie);
            }
        }
        return temp;
    }

    @Override
    public boolean editMovieDetails(Movie movie)
    {
        Movie old = this.getMovie(movie.getID());
        if (old == null) {
            return false;
        }
        old.setName(movie.getName());
        old.setDescription(movie.getDescription());
        old.setDuration(movie.getDuration());
        old.setFormat(movie.getFormat());
        old.setGenre(movie.getGenre());
        old.setReleaseDate(movie.getReleaseDate());

        return true;

    }

    @Override
    public boolean deleteMovie(int id) {
        Movie movie = getMovie(id);

        if (movie != null) {
            movies.remove(movie);
        }

        return false;
    }
}


