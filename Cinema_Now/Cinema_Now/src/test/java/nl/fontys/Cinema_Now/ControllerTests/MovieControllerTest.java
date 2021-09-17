package nl.fontys.Cinema_Now.ControllerTests;

import nl.fontys.Cinema_Now.Controllers.MoviesController;
import nl.fontys.Cinema_Now.DTO.Enums.Format;
import nl.fontys.Cinema_Now.DTO.Enums.Genre;
import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.Repository.FakeDataMovies;
import nl.fontys.Cinema_Now.Services.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

public class MovieControllerTest {
//    @Test
//    public void createMovieTest()
//    {
//        MoviesController controller = new MoviesController(new MovieService(new FakeDataMovies()));
//        Movie avengers = new Movie("Avengers", Genre.ACTION, 180, "05/05/2012", "Earth's mightiest heroes are shown a difficult task to save New York from Loki.", Format._4DX);
//
//        ResponseEntity<Movie> response = controller.createMovie(avengers);
//        Assertions.asser("<201 CREATED Created,movie/11,[]>",response);
//
//
//    }
}
