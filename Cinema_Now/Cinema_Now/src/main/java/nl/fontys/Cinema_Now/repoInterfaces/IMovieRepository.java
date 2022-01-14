package nl.fontys.Cinema_Now.repoInterfaces;

import nl.fontys.Cinema_Now.model.Enums.Format;
import nl.fontys.Cinema_Now.model.Enums.Genre;
import nl.fontys.Cinema_Now.model.Movie;
import nl.fontys.Cinema_Now.model.Projection;
import nl.fontys.Cinema_Now.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, String> {
    List<Movie> findMoviesByGenre(String genre);
    @Query(value = "SELECT * FROM movies INNER JOIN projection AS p WHERE p.date = ?1 ",
            nativeQuery = true)
    List<Movie> getMoviesByProjections(String date);

    @Modifying
    @Transactional
    @Query( value = "UPDATE movies as m "+
            "INNER JOIN movies_projections as mp on m.id=:movieId " +
            "SET m.description=:description, m.director=:director, m.duration=:duration, m.format=:format, m.genre=:genre , m.name=:name , m.release_date=:releaseDate , m.room_id=:room , mp.projections_id=:projectionId " +
            "WHERE m.id=:movieId", nativeQuery = true)
    void updateMovieWithoutImage(
            @Param("description") String description,
            @Param("director") String director,
            @Param("duration") int duration,
            @Param("format") int format,
            @Param("genre") int genre,
            @Param("name") String name,
            @Param("releaseDate") String releaseDate,
            @Param("room") Room room,
            @Param("projectionId") Collection<String> projections,
            @Param("movieId") String movieId);
}
