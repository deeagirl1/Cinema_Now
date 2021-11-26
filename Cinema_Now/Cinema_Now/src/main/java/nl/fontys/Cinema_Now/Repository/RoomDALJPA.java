package nl.fontys.Cinema_Now.Repository;

import nl.fontys.Cinema_Now.DALInterfaces.IRoomDAL;
import nl.fontys.Cinema_Now.Model.Room;
import nl.fontys.Cinema_Now.RepoInterfaces.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository @Transactional
public class RoomDALJPA implements IRoomDAL {

    @Autowired
    IRoomRepository repo;

    @Override
    public List<Room> getAllRooms() {
        return repo.findAll();
    }

    @Override
    public Room getRoomById(String id) {
        return repo.findById(id).get();
    }

    @Override
    public boolean createRoom(Room room) {
         repo.save(room);
         return true;
    }

    @Override
    public boolean deleteRoom(String id) {
        repo.deleteById(id);
        return true;
    }

    @Override
    public boolean updateRoom(Room room) {
        Room updatedRoom = this.getRoomById(room.getRoom_id());
        updatedRoom.setCapacity(room.getCapacity());
        updatedRoom.setName(room.getName());
        repo.save(updatedRoom);
        return true;
    }
}
