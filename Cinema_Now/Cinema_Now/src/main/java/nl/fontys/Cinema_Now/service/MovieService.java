package nl.fontys.Cinema_Now.service;

import nl.fontys.Cinema_Now.converters.MovieConverter;
import nl.fontys.Cinema_Now.converters.ProjectionConverter;
import nl.fontys.Cinema_Now.dalInterfaces.IMovieDAL;
import nl.fontys.Cinema_Now.dalInterfaces.IProjectionDAL;
import nl.fontys.Cinema_Now.dalInterfaces.IRoomDAL;
import nl.fontys.Cinema_Now.dto.ProjectionDTO;
import nl.fontys.Cinema_Now.model.Projection;
import nl.fontys.Cinema_Now.model.Room;
import nl.fontys.Cinema_Now.dto.MovieDTO;
import nl.fontys.Cinema_Now.model.Enums.Format;
import nl.fontys.Cinema_Now.model.Enums.Genre;
import nl.fontys.Cinema_Now.model.Movie;
import nl.fontys.Cinema_Now.serviceInterface.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;

@Service @Transactional
public class MovieService implements IMovieService {

    private IMovieDAL dal;
    private MovieConverter converter;
    private IProjectionDAL projectionDAL;
    private ProjectionConverter projectionConverter;
    private IRoomDAL roomDAL;

    @Autowired
    public MovieService(IMovieDAL dal, MovieConverter converter, IProjectionDAL projectionDAL, ProjectionConverter projectionConverter, IRoomDAL roomDAL) {

        this.dal = dal;
        this.converter = converter;
        this.projectionDAL = projectionDAL;
        this.projectionConverter = projectionConverter;
        this.roomDAL = roomDAL;
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        return converter.entityToDto(dal.getAllMovies());
    }

    @Override
    public MovieDTO getMovie(String id) {
        return converter.entityToDto(dal.getMovie(id));
    }

    @Override
    public boolean addMovie(MovieDTO movie, MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        if (movie != null) {
            Collection<Projection> projections = new ArrayList<>();
            for (ProjectionDTO dto: movie.getProjections()
            ) {
                Projection projection = projectionDAL.getProjectionById(dto.getId());
                projections.add(projection);
            }
            Movie entity = converter.dtoToEntity(movie, fileName, file.getBytes());
            Room room = this.roomDAL.getRoomById(movie.getRoomId());
            if (room != null) {
                entity.setRoom(room);
                entity.setProjections(projections);
            }
            dal.addMovie(entity);
            return true;
        }
        return false;
    }




    @Override
    public List<MovieDTO> getMoviesBasedOnGenre(String genre) {

        List<MovieDTO> temp = new ArrayList<>();
        for (MovieDTO movie : this.getAllMovies()) {
            if (genre.contains(movie.getGenre().toString())) {
                temp.add(movie);
            }
        }
        return temp;

    }

    @Override
    public boolean editMovieDetails(MovieDTO movie) {
        Movie oldEntity = dal.getMovie(movie.getId());
        Room room = roomDAL.getRoomById(movie.getRoomId());
        Collection<Projection> projections = new ArrayList<>();
        for (ProjectionDTO dto: movie.getProjections()
             ) {
             Projection projection = projectionDAL.getProjectionById(dto.getId());
             projections.add(projection);
        }
        if(room != null && oldEntity != null) {
            Movie newEntity = new Movie(movie.getId(),
                    movie.getName(),
                    movie.getGenre(),
                    movie.getDuration(),
                    movie.getReleaseDate(),
                    movie.getDescription(),
                    movie.getFormat(),
                    movie.getDirector(),
                    room,projections);
            dal.editMovieWithoutPicture(newEntity);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteMovie(String id) {
        if(this.getMovie(id) != null) {
            dal.deleteMovie(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Genre> getAllGenres() {
        return Arrays.asList(Genre.values());
    }

    @Override
    public List<Format> getAllFormats() {
        return  Arrays.asList(Format.values());
    }

    @Override
    public List<MovieDTO> getMoviesByProjectionDate(String date) {
        return converter.entityToDto(dal.getMoviesByProjectionDate(date));
    }

}


