package nl.fontys.Cinema_Now.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.fontys.Cinema_Now.converters.MovieConverter;
import nl.fontys.Cinema_Now.dto.FileDTO;
import nl.fontys.Cinema_Now.dto.MovieDTO;
import nl.fontys.Cinema_Now.dto.ProjectionDTO;
import nl.fontys.Cinema_Now.model.Enums.Format;
import nl.fontys.Cinema_Now.model.Enums.Genre;
import nl.fontys.Cinema_Now.model.Movie;
import nl.fontys.Cinema_Now.model.Projection;
import nl.fontys.Cinema_Now.model.Room;
import nl.fontys.Cinema_Now.serviceInterface.IFileService;
import nl.fontys.Cinema_Now.serviceInterface.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/movie")
public class MoviesController {


    private final IMovieService service;
    private final IFileService fileService;

    @Autowired
    public MoviesController(IMovieService service, IFileService fileService)
    {
         this.service=service;
         this.fileService = fileService;

    }


    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    //GET at /movies
    public ResponseEntity<List<MovieDTO>> getAllMovies()
    {

        var movies = service.getAllMovies();

        if(movies != null)
        {
            return ResponseEntity.ok().body(getImagePath(movies));
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
            movie.setMovieImage(getImagePath(movie.getId()));
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
            return ResponseEntity.ok().body(getImagePath(movies));
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
    public ResponseEntity<MovieDTO> createMovie(@RequestParam("file") MultipartFile file, String jsonFileVo) throws IOException {
        try {
            if (file == null) {

                return ResponseEntity.notFound().build();
            } else {
               MovieDTO movie = new ObjectMapper().readValue(jsonFileVo, MovieDTO.class);
               service.addMovie(movie, file);
                return ResponseEntity.ok().body(movie);
            }
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
        }
    }

    @DeleteMapping("{id}")
    //DELETE at http://localhost:XXXX/movie
    public ResponseEntity<MovieDTO> deleteMovie(@PathVariable("id") String id) {
        service.deleteMovie(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String id) {
        FileDTO file = fileService.getImageByMovieId(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .body(file.getFileData());
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

    private String getImagePath(String movieId){
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/movie/files/")
                .path(movieId)
                .toUriString();
    }

    private List<MovieDTO> getImagePath(List<MovieDTO> movies){
        for (MovieDTO movie: movies){
            movie.setMovieImage(getImagePath(movie.getId()));
        }
        return movies;
    }
}





