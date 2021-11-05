package nl.fontys.Cinema_Now.Controller;

import nl.fontys.Cinema_Now.DTO.MovieDTO;
import nl.fontys.Cinema_Now.Model.Movie;
import nl.fontys.Cinema_Now.ServiceInterface.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Locale;

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
    public ResponseEntity getMovieById(@PathVariable(value = "id")  String id) {
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
    public ResponseEntity createMovie(@RequestBody MovieDTO dto) {
        if (dto == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            service.addMovie(dto);
            return ResponseEntity.ok().build();
        }
    }
    @DeleteMapping("{id}")
    //DELETE at http://localhost:XXXX/movie
    public ResponseEntity deleteMovie(@PathVariable("id") String id) {
        service.deleteMovie(id);
        return ResponseEntity.ok().build();

    }
   // PUT at http://localhost:XXXX/movie
    @PutMapping()
    public ResponseEntity updatePost(@RequestBody MovieDTO movie)
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






