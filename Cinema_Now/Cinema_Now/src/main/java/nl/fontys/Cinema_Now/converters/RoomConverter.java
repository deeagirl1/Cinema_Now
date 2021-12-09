package nl.fontys.Cinema_Now.converters;

import nl.fontys.Cinema_Now.dto.RoomDTO;
import nl.fontys.Cinema_Now.model.Room;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoomConverter {

    public RoomDTO entityToDto(Room room)
    {
        RoomDTO dto = new RoomDTO();
        dto.setId(room.getId());
        dto.setName(room.getName());
        dto.setCapacity(room.getCapacity());
        return dto;

    }
    public List<RoomDTO> entityToDto(List<Room> rooms)
    {
        return rooms.stream().map(this::entityToDto).collect(Collectors.toList());

    }
    public Room dtoToEntity(RoomDTO dto)
    {
        Room entity = new Room();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCapacity(dto.getCapacity());

        return entity;

    }
    public List<Room> dtoToEntity(List<RoomDTO> rooms)
    {
        return rooms.stream().map(this::dtoToEntity).collect(Collectors.toList());

    }
}
