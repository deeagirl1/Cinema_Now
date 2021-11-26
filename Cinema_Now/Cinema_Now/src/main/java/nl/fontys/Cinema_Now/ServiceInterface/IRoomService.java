package nl.fontys.Cinema_Now.ServiceInterface;

import nl.fontys.Cinema_Now.DTO.RoomDTO;
import nl.fontys.Cinema_Now.Model.Room;

import java.util.List;

public interface IRoomService {
    List<Room> getAllRooms();
    Room getRoomById(String id);
    boolean createRoom(RoomDTO room);
    boolean editRoom(RoomDTO room);
    boolean deleteRoom(String id);
    boolean checkCapacity(String id);
}
