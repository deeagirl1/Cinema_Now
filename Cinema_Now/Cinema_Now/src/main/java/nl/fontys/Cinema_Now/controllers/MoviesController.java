package nl.fontys.Cinema_Now.controllers;

import nl.fontys.Cinema_Now.dto.MovieDTO;
import nl.fontys.Cinema_Now.model.Enums.Format;
import nl.fontys.Cinema_Now.model.Enums.Genre;
import nl.fontys.Cinema_Now.serviceInterface.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/movie")
public class MoviesController {


    private final IMovieService service;

    @Autowired
    public MoviesController(IMovieService service)
    {
         this.service=service;
    }


    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    //GET at /movies
    public ResponseEntity<List<MovieDTO>> getAllMovies()
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
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable(value = "id")  String id) {
        MovieDTO movie = service.getMovie(id);

        if(movie != null) {
            return ResponseEntity.ok().body(movie);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> getGenres() {
        var genres = service.getAllGenres();

        if(genres != null)
        {
            return ResponseEntity.ok().body(genres);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping("/formats")
    public ResponseEntity<List<Format>> getFormats() {
        var formats = service.getAllFormats();

        if(formats != null)
        {
            return ResponseEntity.ok().body(formats);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

//    GET at movies/action
    @GetMapping("genre/{genre}")
    public ResponseEntity<List<MovieDTO>> getAllMoviesBasedOnGenre(@PathVariable(value = "genre")  String genre) {
        List<MovieDTO> movies = service.getMoviesBasedOnGenre(genre);

        if (movies != null) {
            return ResponseEntity.ok().body(movies);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping("/projections")
    public ResponseEntity<List<MovieDTO>> getMoviesByProjectionDate(@RequestParam(value = "date")  String date) {
        List<MovieDTO> movies = service.getMoviesByProjectionDate(date);
        if (movies != null) {
            return ResponseEntity.ok().body(movies);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    //POST at http://localhost:8080/movie
    @PostMapping()
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO dto) {
        if (dto == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.addMovie(dto);
            return ResponseEntity.ok().body(dto);
        }
    }

    @DeleteMapping("{id}")
    //DELETE at http://localhost:XXXX/movie
    public ResponseEntity<MovieDTO> deleteMovie(@PathVariable("id") String id) {
        service.deleteMovie(id);
        return ResponseEntity.ok().build();

    }
    //PUT at http://localhost:XXXX/movie
    @PutMapping()
    public ResponseEntity<MovieDTO> updateMovie(@RequestBody MovieDTO movie)
    {
        if(service.editMovieDetails(movie))
        {
            return ResponseEntity.ok().body(movie);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}





