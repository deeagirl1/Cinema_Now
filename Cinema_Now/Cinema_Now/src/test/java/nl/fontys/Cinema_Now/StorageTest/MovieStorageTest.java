package nl.fontys.Cinema_Now.StorageTest;

import nl.fontys.Cinema_Now.DTO.Enums.Format;
import nl.fontys.Cinema_Now.DTO.Enums.Genre;
import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.Repository.FakeDataMovies;
import nl.fontys.Cinema_Now.Services.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.BooleanSupplier;

public class MovieStorageTest {

    @Test
    public void getAllMovies_returnAllMoviesTest()
    {
        MovieService data = new MovieService(new FakeDataMovies());
        List<Movie> movies = data.GetAllMovies();

        Assertions.assertNotNull(movies);
    }

    @Test
    public void getMovieByGenreTest()
    {
        MovieService data = new MovieService(new FakeDataMovies());
        Movie movie1 = new Movie(1,("Cars"), Genre.ANIMATION,180,"06/06/2006","Test", Format._3D);
        var genre = movie1.getGenre();
        data.GetMoviesBasedOnGenre(movie1.getGenre().toString());

        Assertions.assertEquals(movie1.getGenre(),genre);
    }


    @Test
    public void getMovieByIDTest()
    {
        MovieService data = new MovieService(new FakeDataMovies());
        Movie movie1 = new Movie(1,("Cars"), Genre.ANIMATION,180,"06/06/2006","Test", Format._3D);
        int id = movie1.getID();

        Assertions.assertEquals(1,id);
    }

    @Test
    public void addNewMovieTest()
    {
        MovieService data = new MovieService(new FakeDataMovies());
        Movie movie1 = new Movie(1,("Cars"), Genre.ANIMATION,180,"06/06/2006","Test", Format._3D);

        data.AddMovie(movie1);


        Assertions.assertEquals(movie1, data.GetMovie(movie1.getID()));
    }


    @Test
    public void deleteMovieExistentTest()
    {
        MovieService movies = new MovieService(new FakeDataMovies());
        movies.deleteMovie(10);

        List<Movie> result = movies.GetAllMovies();

        Assertions.assertFalse(result.isEmpty());

    }

    @Test
    public void deleteMovieNonExistentTest()
    {
        MovieService movies = new MovieService(new FakeDataMovies());
        movies.deleteMovie(11);

        List<Movie> result = movies.GetAllMovies();

        Assertions.assertFalse(result.isEmpty());

    }

}
