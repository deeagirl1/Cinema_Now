package nl.fontys.Cinema_Now.service;

import nl.fontys.Cinema_Now.converters.RoomConverter;
import nl.fontys.Cinema_Now.dalInterfaces.IRoomDAL;
import nl.fontys.Cinema_Now.dalInterfaces.ITicketDAL;
import nl.fontys.Cinema_Now.dto.RoomDTO;
import nl.fontys.Cinema_Now.model.Room;
import nl.fontys.Cinema_Now.serviceInterface.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
public class RoomService implements IRoomService {

    private final IRoomDAL data;
    private final RoomConverter converter;

    @Autowired
    public RoomService(IRoomDAL data, RoomConverter converter)
    {

        this.data = data;
        this.converter = converter;
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        return converter.entityToDto(data.getAllRooms());
    }

    @Override
    public RoomDTO getRoomById(String id) {
        return converter.entityToDto(data.getRoomById(id));
    }

    @Override
    public boolean createRoom(RoomDTO room){
        if(room != null)
        {
            Room entity = converter.dtoToEntity(room);
            data.createRoom(entity);
            return true;
        }
      return false;
    }

    @Override
    public boolean editRoom(RoomDTO room) {
        Room updatedRoom = converter.dtoToEntity(this.getRoomById(room.getId()));
        updatedRoom.setCapacity(room.getCapacity());
        updatedRoom.setName(room.getName());
        updatedRoom.setId(room.getId());
        return data.updateRoom(updatedRoom);
    }

    @Override
    public boolean deleteRoom(String id) {
        if(!id.isBlank()) {

            data.deleteRoom(id);
            return true;
        }
        return false;
    }

}

