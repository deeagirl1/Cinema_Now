package nl.fontys.Cinema_Now.Repository;
import nl.fontys.Cinema_Now.DTO.Enums.Format;
import nl.fontys.Cinema_Now.DTO.Enums.Genre;
import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.Interfaces.Data.IMovieData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class FakeDataMovies implements IMovieData {
    private final List<Movie> movies = new ArrayList<>();

    public FakeDataMovies()
    {
//        Movie avengers = new Movie("Avengers", Genre.ACTION,180, "05/05/2012","Earth's mightiest heroes are shown a difficult task to save New York from Loki.", Format._4DX);
//
//        movies.add(avengers);

    }

    @Override
    public List<Movie> GetAllMovies() {
        return movies;
    }

    @Override
    public Movie GetMovie(int id) {
        for (Movie movie : movies)
        {
            if(movie.getID() == id)
            {
                return movie;
            }
        }
        return null;
    }

    @Override
    public boolean AddMovie(Movie movie) {
        if(this.GetMovie(movie.getID()) != null)
        {
            return  false;
        }
        movies.add((movie));
        return true;
    }

    @Override
    public List<Movie>  GetMoviesBasedOnGenre(String genre) {
        List<Movie> temp = new ArrayList<>();
        for(Movie movie : movies){
            if(genre.contains(movie.getGenre().toString().toLowerCase(Locale.ROOT)))
            {
                temp.add(movie);
            }
        }
        return temp;
    }
}


