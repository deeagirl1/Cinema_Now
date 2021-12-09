package nl.fontys.Cinema_Now.serviceInterface;

import nl.fontys.Cinema_Now.dto.RoomDTO;
import nl.fontys.Cinema_Now.model.Room;

import java.util.List;

public interface IRoomService {
    List<RoomDTO> getAllRooms();
    RoomDTO getRoomById(String id);
    boolean createRoom(RoomDTO room);
    boolean editRoom(RoomDTO room);
    boolean deleteRoom(String id);
}
