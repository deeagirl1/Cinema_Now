package nl.fontys.Cinema_Now.Converter;

import nl.fontys.Cinema_Now.DTO.RoomDTO;
import nl.fontys.Cinema_Now.Model.Room;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoomConverter {
    public RoomDTO entityToDto(Room room)
    {
        RoomDTO dto = new RoomDTO();
        dto.setRoomName(room.getName());
        dto.setCapacity(room.getCapacity());
        dto.setMovie_id(room.getMovie().getId());
        dto.setNrOfTicket(room.getTickets());
        return dto;

    }
    public List<RoomDTO> entityToDto(List<Room> rooms)
    {
        return rooms.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }
    public Room dtoToEntity(RoomDTO dto)
    {
        Room entity = new Room();

        entity.setName(dto.getRoomName());
        entity.setCapacity(dto.getCapacity());
        entity.setTickets(dto.getNrOfTicket());

        return entity;

    }
    public List<Room> dtoToEntity(List<RoomDTO> rooms)
    {
        return rooms.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());

    }
}
