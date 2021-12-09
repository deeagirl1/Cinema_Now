package nl.fontys.Cinema_Now.repoInterfaces;

import nl.fontys.Cinema_Now.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, String> {
    List<Movie> findMoviesByGenre(String genre);
    @Query(value = "SELECT * FROM movies INNER JOIN projection AS p WHERE p.date = ?1 ",
            nativeQuery = true)
    List<Movie> getMoviesByProjections(String date);
}
