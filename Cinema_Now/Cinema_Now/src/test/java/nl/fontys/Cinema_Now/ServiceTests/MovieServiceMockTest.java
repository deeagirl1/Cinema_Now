package nl.fontys.Cinema_Now.ServiceTests;

import nl.fontys.Cinema_Now.Converter.MovieConverter;
import nl.fontys.Cinema_Now.DALInterfaces.IMovieDAL;
import nl.fontys.Cinema_Now.DTO.MovieDTO;
import nl.fontys.Cinema_Now.Model.Enums.Format;
import nl.fontys.Cinema_Now.Model.Enums.Genre;
import nl.fontys.Cinema_Now.Model.Movie;
import nl.fontys.Cinema_Now.Service.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
public class MovieServiceMockTest {

    @Mock
    private IMovieDAL movieDAL;

    @BeforeEach
    public void setUp()
    {
        List<Movie> movies = List.of(
                new Movie("1","Cars", Genre.ANIMATION, 180, "06/06/2006", "Explore Radiator Spring with Lighting McQueen and Tow Mater.", Format._3D),
                new Movie("2","Toy Story 3", Genre.ANIMATION, 200, "15/06/2010", "Woody amd Buzz adventure into the unknown when Andy grows up and has to give them away.", Format._3D),
                new Movie("3","Avengers", Genre.ACTION, 200, "07/05/2012", "Loki invaded Earth with centaurs. When all hope is lost, avengers come to save the day.", Format._3D)
        );

        when(movieDAL.getAllMovies()).thenReturn(movies);
        when(movieDAL.getMovie("1")).thenReturn(movies.get(0));
        when(movieDAL.getMoviesBasedOnGenre("animation")).thenReturn(movies);
        when(movieDAL.deleteMovie("1")).thenReturn(true);

    }

    @Test
    public void getMoviesBasedOnGenreTest()
    {
        //arrange
        MovieService service = new MovieService(movieDAL,new MovieConverter());
        //act
        List<Movie> movies = service.getMoviesBasedOnGenre("animation");
        //assert
        Assertions.assertEquals(Genre.ANIMATION,movies.get(0).getGenre());
        Assertions.assertEquals(Genre.ANIMATION,movies.get(1).getGenre());
    }

        @Test
        public void getAllMoviesTest()
        {
            //arrange
            MovieService service = new MovieService(movieDAL,new MovieConverter());
            //act
            List<Movie> movies = service.getAllMovies();
            //assert
            Assertions.assertEquals("Cars",movies.get(0).getName());
        }
    @Test
    public void getMovieById()
    {
        //arrange
        MovieService service = new MovieService(movieDAL,new MovieConverter());
        //act
        Movie movie = service.getMovie("1");
        //assert
        Assertions.assertEquals("1",movie.getID());
    }

        @Test
        public void deleteMovieTest()
        {
            //arrange
            MovieService service = new MovieService(movieDAL,new MovieConverter());
            //act
            List<Movie> movies = service.getAllMovies();
            var result = service.deleteMovie(movies.get(0).getID());
            //assert
            Assertions.assertTrue(result);

        }

        @Test
        public void addMovieTest()
        {
            //arrange
            MovieService service = new MovieService(movieDAL,new MovieConverter());
            MovieDTO movie = new MovieDTO("Cars",Genre.ANIMATION,180 , "26/06/2021","test",Format._4DX,"test");

            service.addMovie(movie);

            //when
            ArgumentCaptor<Movie> movieArgumentCaptor = ArgumentCaptor.forClass(Movie.class);

            verify(movieDAL).addMovie(movieArgumentCaptor.capture());

            Movie captureMovie = movieArgumentCaptor.getValue();
            //assert
            Assertions.assertEquals(movie.getName(),captureMovie.getName());

        }

    @Test
    public void updateMovieTest()
    {
        //arrange
        MovieService service = new MovieService(movieDAL,new MovieConverter());
        MovieDTO movie = new MovieDTO("Cars",Genre.ANIMATION,180 , "26/06/2021","test",Format._4DX,"test");
        service.addMovie(movie);
        movie.setDescription("Test");
        service.editMovieDetails(movie);
        //when
        ArgumentCaptor<Movie> movieArgumentCaptor = ArgumentCaptor.forClass(Movie.class);

        verify(movieDAL).editMovie(movieArgumentCaptor.capture());

        Movie captureMovie = movieArgumentCaptor.getValue();
        //assert
        Assertions.assertEquals(movie.getName(),captureMovie.getName());

    }

}
