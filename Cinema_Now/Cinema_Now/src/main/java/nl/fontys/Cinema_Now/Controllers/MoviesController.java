package nl.fontys.Cinema_Now.Controllers;

import nl.fontys.Cinema_Now.DTO.Enums.Format;
import nl.fontys.Cinema_Now.DTO.Enums.Genre;
import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.DTO.News;
import nl.fontys.Cinema_Now.DTO.User;
import nl.fontys.Cinema_Now.Interfaces.Managers.IMovieService;
import nl.fontys.Cinema_Now.Repository.FakeDataMovies;
import nl.fontys.Cinema_Now.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Locale;


@RestController
@RequestMapping("/movies")
public class MoviesController {


    private IMovieService service;

    @Autowired
    public MoviesController(IMovieService service)
    {
         this.service=service;
    }

    //GET at /movies

    @GetMapping
    public ResponseEntity getAllMovies()
    {
        List<Movie> movies = null;
        movies = service.GetAllMovies();

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
        List<Movie> movies = service.GetMoviesBasedOnGenre(genre.toLowerCase(Locale.ROOT));

        if (movies != null) {
            return ResponseEntity.ok().body(movies);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    //POST at http://localhost:8080/movies
    @PostMapping()
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        if (!service.AddMovie(movie)){
            String entity =  "Movie  " + movie.getName()+ " already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {
            String url = "movie" + "/" + movie.getID(); // url of the created student
            URI uri = URI.create(url);
            return new ResponseEntity(uri,HttpStatus.CREATED);
        }
    }
    @DeleteMapping()
    //DELETE at http://localhost:XXXX/movies/
    public ResponseEntity<Movie> deleteMovie(@RequestBody int id) {
        service.deleteMovie(id);
        return ResponseEntity.ok().build();

    }
    //PUT at http://localhost:XXXX/movies/
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






