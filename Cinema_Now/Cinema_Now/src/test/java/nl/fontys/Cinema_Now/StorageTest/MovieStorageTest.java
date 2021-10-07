package nl.fontys.Cinema_Now.StorageTest;

import nl.fontys.Cinema_Now.Modules.Enums.Format;
import nl.fontys.Cinema_Now.Modules.Enums.Genre;
import nl.fontys.Cinema_Now.Modules.Movie;
import nl.fontys.Cinema_Now.Repository.FakeDataMovies;
import nl.fontys.Cinema_Now.Services.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MovieStorageTest {

    @Test
    public void getAllMovies_checkListNotEmpty()
    {
        MovieService data = new MovieService(new FakeDataMovies());
        List<Movie> movies = data.getAllMovies();

        Assertions.assertNotNull(movies);
    }
    @Test
    public void getAllMovies_ReturnNrOfElemends() //rethink
    {
        MovieService data = new MovieService(new FakeDataMovies());
        Movie movie1 = new Movie(1,("Cars"), Genre.ANIMATION,180,"06/06/2006","Test", Format._3D);
        data.addMovie(movie1);
        List<Movie> movies = data.getAllMovies();
        var result = movies.size();

        Assertions.assertEquals(2,result);
    }

    @Test
    public void getMovieByGenreTest()
    {
        MovieService data = new MovieService(new FakeDataMovies());
        Movie movie1 = new Movie(1,("Cars"), Genre.ANIMATION,180,"06/06/2006","Test", Format._3D);
        var genre = movie1.getGenre();
        data.getMoviesBasedOnGenre(movie1.getGenre().toString());

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

        data.addMovie(movie1);


        Assertions.assertEquals(movie1, data.getMovie(movie1.getID()));
    }


    @Test
    public void deleteMovieExistentTest()
    {
        MovieService movies = new MovieService(new FakeDataMovies());
        movies.deleteMovie(10);

        List<Movie> result = movies.getAllMovies();

        Assertions.assertFalse(result.isEmpty());

    }


}
