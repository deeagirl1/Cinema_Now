package nl.fontys.Cinema_Now.Controllers;

import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.Repository.FakeDataMovies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private static final FakeDataMovies fakeData = new FakeDataMovies();

    //GET at /movies
    @GetMapping
    public ResponseEntity getAllMovies()
    {
        List<Movie> movies = null;
        movies = fakeData.GetAllMovies();

        if(movies != null)
        {
            return ResponseEntity.ok().body(movies);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
    //GET at movies/action e…g
    @GetMapping("{genre}")
    public ResponseEntity getAllMoviesBasedOnGenre(@PathVariable(value = "genre")  String genre) {
        List<Movie> movies = fakeData.GetMoviesBasedOnGenre(genre.toLowerCase(Locale.ROOT));

        if (movies != null) {
            return ResponseEntity.ok().body(movies);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    //POST at http://localhost:8080/movies
    @PostMapping()
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        if (!fakeData.AddMovie(movie)){
            String entity =  "Movie  " + movie.getName()+ " already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {
            String url = "movie" + "/" + movie.getID(); // url of the created student
            URI uri = URI.create(url);
            return new ResponseEntity(uri,HttpStatus.CREATED);
        }
    }
}






