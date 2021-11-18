package nl.fontys.Cinema_Now.DALInterfaces;

import nl.fontys.Cinema_Now.Model.Room;
import java.util.List;

public interface IRoomDAL {
    List<Room> getAllRooms();
    Room getRoomById(String id);
    boolean createRoom(Room room);
    boolean deleteRoom(String id);
    boolean updateRoom(Room room);
}
