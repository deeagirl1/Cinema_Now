package nl.fontys.Cinema_Now.RepoInterfaces;

import nl.fontys.Cinema_Now.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomRepository extends JpaRepository<Room, String> {

}
