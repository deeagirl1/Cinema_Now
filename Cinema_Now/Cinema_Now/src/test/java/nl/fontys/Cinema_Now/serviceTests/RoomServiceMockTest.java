package nl.fontys.Cinema_Now.serviceTests;

import nl.fontys.Cinema_Now.converters.RoomConverter;
import nl.fontys.Cinema_Now.dalInterfaces.IRoomDAL;
import nl.fontys.Cinema_Now.dto.RoomDTO;
import nl.fontys.Cinema_Now.model.Room;
import nl.fontys.Cinema_Now.service.RoomService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
public class RoomServiceMockTest {
    
    @Mock
    private IRoomDAL roomDAL;

    private RoomService service;
    private final RoomConverter converter = new RoomConverter();


    @BeforeEach
    public void setUp()
    {
        service = new RoomService(roomDAL,converter);
        List<Room> rooms = List.of(
                new Room("1","test",20),
                new Room("2","test",20),
                new Room("","test",20)
        );


        when(roomDAL.getRoomById("1")).thenReturn(rooms.get(0));
        when(roomDAL.deleteRoom("1")).thenReturn(true);
        when(roomDAL.getAllRooms()).thenReturn(rooms);
    }

    @Test
    public void getAllRoomsTest()
    {
        //arrange

        //act
        List<RoomDTO> rooms = service.getAllRooms();

        //assert
        Assertions.assertEquals("1", rooms.get(0).getId());
        Assertions.assertEquals("2", rooms.get(1).getId());
    }
    @Test
    public void getRoomByIdTest()
    {
        //arrange
        RoomDTO room = new RoomDTO("4","213",20);
        //act
        when(roomDAL.getRoomById("4")).thenReturn(converter.dtoToEntity(room));
        RoomDTO roomToBeChecked =service.getRoomById("4");

        //assert
        Assertions.assertEquals("213", roomToBeChecked.getName());
    }

    @Test
    public void deleteRoom_returnFalse()
    {
        //act
        List<RoomDTO> rooms = service.getAllRooms();
        var result = service.deleteRoom(rooms.get(2).getId());

        Assertions.assertFalse(result);

    }

    @Test
    public void deleteRoomTest_returnTrue()
    {

        //act
        List<RoomDTO> rooms = service.getAllRooms();
        var result = service.deleteRoom(rooms.get(0).getId());

        Assertions.assertTrue(result);

    }

    @Test
    public void addRoomTest()
    {
        //arrange
        //act
        RoomDTO room = new RoomDTO("4","213",20);
        service.createRoom(room);

        ArgumentCaptor<Room> roomArgumentCaptor = ArgumentCaptor.forClass(Room.class);

        verify(roomDAL).createRoom(roomArgumentCaptor.capture());

        Room captureRoom = roomArgumentCaptor.getValue();

        Assertions.assertEquals(room.getCapacity(), captureRoom.getCapacity());

    }

    @Test
    public void updateUserTest_returnTrue()
    {


    }

}
