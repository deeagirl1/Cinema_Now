package nl.fontys.Cinema_Now.repository;

import nl.fontys.Cinema_Now.dalInterfaces.IRoomDAL;
import nl.fontys.Cinema_Now.model.Room;
import nl.fontys.Cinema_Now.repoInterfaces.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository @Transactional
public class RoomDALJPA implements IRoomDAL {


    private final IRoomRepository repo;

    @Autowired
    public RoomDALJPA(IRoomRepository repo) {
        this.repo = repo;
    }

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
        if(room != null) {
            repo.save(room);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRoom(String id) {
        if(this.getRoomById(id) != null) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRoom(Room room) {
         repo.save(room);
         return true;

    }

}
