package nl.fontys.Cinema_Now.serviceTests;

import nl.fontys.Cinema_Now.converters.MovieConverter;
import nl.fontys.Cinema_Now.converters.ProjectionConverter;
import nl.fontys.Cinema_Now.dalInterfaces.IMovieDAL;
import nl.fontys.Cinema_Now.dalInterfaces.IProjectionDAL;
import nl.fontys.Cinema_Now.dalInterfaces.IRoomDAL;
import nl.fontys.Cinema_Now.dto.MovieDTO;
import nl.fontys.Cinema_Now.model.Enums.Format;
import nl.fontys.Cinema_Now.model.Enums.Genre;
import nl.fontys.Cinema_Now.model.Movie;
import nl.fontys.Cinema_Now.model.Projection;
import nl.fontys.Cinema_Now.model.Room;
import nl.fontys.Cinema_Now.service.MovieService;
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
    @Mock
    private IProjectionDAL projectionDAL;
    @Mock
    private IRoomDAL roomDAL;

    private MovieService service;

    private final ProjectionConverter projectionConverter = new ProjectionConverter();

    @BeforeEach
    public void setUp()
    {
        service = new MovieService(movieDAL,new MovieConverter(),projectionDAL,projectionConverter, roomDAL);

        List<Projection> projections = List.of(
                new Projection("1","25/05/2021","15:00"),
                new Projection("2","26/05/2021","15:00"),
                new Projection("3","27/05/2021","15:00")
        );

        List<Room> rooms = List.of(
                new Room("1","test",20),
                new Room("2","test",20),
                new Room("3","test",20)
        );

        List<Movie> movies = List.of(
                new Movie("1","Cars", Genre.ANIMATION, 180, "06/06/2006", "Explore Radiator Spring with Lighting McQueen and Tow Mater.",  Format._3D,"test", rooms.get(0),projections),
                new Movie("2","Toy Story 3", Genre.ANIMATION, 200, "15/06/2010", "Woody amd Buzz adventure into the unknown when Andy grows up and has to give them away.", Format._3D, "test",rooms.get(1)),
                new Movie("3","Avengers", Genre.ACTION, 200, "07/05/2012", "Loki invaded Earth with centaurs. When all hope is lost, avengers come to save the day.", Format._3D, "test", rooms.get(2))
        );



        when(movieDAL.getAllMovies()).thenReturn(movies);
        when(movieDAL.getMovie("1")).thenReturn(movies.get(0));
        when(movieDAL.getMoviesBasedOnGenre("animation")).thenReturn(movies);
        when(movieDAL.deleteMovie("1")).thenReturn(true);

        when(roomDAL.getRoomById("1")).thenReturn(rooms.get(0));
        when(projectionDAL.getProjectionById("1")).thenReturn(projections.get(0));
        when(projectionDAL.getAllProjections()).thenReturn(projections);


    }

    @Test
    public void getAllMoviesTest()
    {
            //arrange
            MovieService service = new MovieService(movieDAL,new MovieConverter(),projectionDAL,new ProjectionConverter(), roomDAL);
            //act
            List<MovieDTO> movies = service.getAllMovies();
            //assert
            Assertions.assertEquals("Toy Story 3",movies.get(1).getName());
    }

    @Test
    public void getMoviesBasedByGenre()
    {
        //arrange
        //act
        List<MovieDTO> movies = service.getMoviesBasedOnGenre(Genre.ANIMATION.toString());
        //assert
        Assertions.assertEquals("Cars",movies.get(0).getName());
        Assertions.assertEquals("Toy Story 3",movies.get(1).getName());
    }

    @Test
    public void getMovieById()
    {
        //arrange
        MovieService service = new MovieService(movieDAL,new MovieConverter(),projectionDAL,new ProjectionConverter(), roomDAL);
        //act
        MovieDTO movie = service.getMovie("1");
        //assert
        Assertions.assertEquals("1",movie.getId());
    }

        @Test
        public void deleteMovieTest()
        {
            //arrange
            MovieService service = new MovieService(movieDAL,new MovieConverter(),projectionDAL,new ProjectionConverter(), roomDAL);
            //act
            List<MovieDTO> movies = service.getAllMovies();
            var result = service.deleteMovie(movies.get(0).getId());
            //assert
            Assertions.assertTrue(result);
        }

    @Test
    public void addMovie()  {
        //Given
        Room room = roomDAL.getRoomById("1");
        List<Projection> projections = projectionDAL.getAllProjections();

        MovieDTO movie = new MovieDTO("4", "Cars", Genre.ANIMATION, 180, "26/06/2021", "test", Format._4DX, "test",room.getId(),projectionConverter.entityToDto(projections));
        service.addMovie(movie);
        //then
        ArgumentCaptor<Movie> jobArgumentCaptor =
                ArgumentCaptor.forClass(Movie.class);
        verify(movieDAL)
                .addMovie(jobArgumentCaptor.capture());
        Movie jobArgumentCaptorValue = jobArgumentCaptor.getValue();

        Assertions.assertEquals(jobArgumentCaptorValue.getName(), "Cars");
    }

    @Test
    public void updateMovieTest()
    {
        //when
        MovieDTO movie = service.getMovie("1");
        movie.setFormat(Format._4DX);
        service.editMovieDetails(movie);

        ArgumentCaptor<Movie> movieArgumentCaptor = ArgumentCaptor.forClass(Movie.class);

        verify(movieDAL).editMovie(movieArgumentCaptor.capture());

        Movie captureMovie = movieArgumentCaptor.getValue();
        //assert
        Assertions.assertEquals(movie.getFormat(),captureMovie.getFormat());

    }

}
