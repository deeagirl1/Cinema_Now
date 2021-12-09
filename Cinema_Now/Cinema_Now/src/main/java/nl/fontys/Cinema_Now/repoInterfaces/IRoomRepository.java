package nl.fontys.Cinema_Now.repoInterfaces;

import nl.fontys.Cinema_Now.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomRepository extends JpaRepository<Room, String> {

}
