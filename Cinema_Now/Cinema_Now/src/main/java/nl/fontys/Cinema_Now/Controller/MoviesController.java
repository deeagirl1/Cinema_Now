package nl.fontys.Cinema_Now.Controller;

import nl.fontys.Cinema_Now.Model.Movie;
import nl.fontys.Cinema_Now.Model.News;
import nl.fontys.Cinema_Now.ServiceInterface.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/movie")
public class MoviesController {


    private IMovieService service;

    @Autowired
    public MoviesController(IMovieService service)
    {
         this.service=service;
    }



    @GetMapping
    //GET at /movies
    public ResponseEntity getAllMovies()
    {

        var movies = service.getAllMovies();

        if(movies != null)
        {
            return ResponseEntity.ok().body(movies);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable(value = "id")  String id) {
        Movie movie = service.getMovie(id);

        if(movie != null) {
            return ResponseEntity.ok().body(movie);
        } else {
            return ResponseEntity.notFound().build();
        }

    }


//    GET at movies/action
    @GetMapping("genre/{genre}")
    public ResponseEntity getAllMoviesBasedOnGenre(@PathVariable(value = "genre")  String genre) {
        List<Movie> movies = service.getMoviesBasedOnGenre(genre.toLowerCase(Locale.ROOT));

        if (movies != null) {
            return ResponseEntity.ok().body(movies);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    //POST at http://localhost:8080/movie
    @PostMapping()
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        service.addMovie(movie);
        var result = service.getMovie(movie.getID());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result)
                .toUri();

        //Send location in response (in the header)
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("{id}")
    //DELETE at http://localhost:XXXX/movie
    public ResponseEntity<Movie> deleteMovie(@PathVariable("id") String id) {
        service.deleteMovie(id);
        return ResponseEntity.ok().build();

    }
   // PUT at http://localhost:XXXX/movie
    @PutMapping()
    public ResponseEntity<Movie> updatePost(@RequestBody Movie movie)
    {
        if(service.editMovieDetails(movie))
        {
            return ResponseEntity.noContent().build();
        }
        else
        {
            return new ResponseEntity("Please provide a movie.",HttpStatus.NOT_FOUND);
        }
    }
}






