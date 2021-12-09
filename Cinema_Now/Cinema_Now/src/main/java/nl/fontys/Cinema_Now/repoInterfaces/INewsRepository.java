package nl.fontys.Cinema_Now.repoInterfaces;

import nl.fontys.Cinema_Now.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INewsRepository extends JpaRepository<News, String> {
}