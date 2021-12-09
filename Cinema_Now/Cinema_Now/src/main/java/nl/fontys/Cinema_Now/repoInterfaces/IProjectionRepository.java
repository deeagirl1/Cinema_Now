package nl.fontys.Cinema_Now.repoInterfaces;

import nl.fontys.Cinema_Now.model.Projection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectionRepository extends JpaRepository<Projection, String> {

}
