package nl.fontys.Cinema_Now.controllers;

import nl.fontys.Cinema_Now.dto.RoomDTO;
import nl.fontys.Cinema_Now.serviceInterface.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final IRoomService service;

    @Autowired
    public RoomController(IRoomService service)
    {
        this.service=service;
    }

    //GET at /rooms
    @GetMapping
    public ResponseEntity<List<RoomDTO>> getAllRooms()
    {
        List<RoomDTO> rooms = service.getAllRooms();

        if(rooms != null)
        {
            return ResponseEntity.ok().body(rooms);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
    //GET at news/1 e…g
    @GetMapping("{id}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable(value = "id")  String id) {
        RoomDTO room = service.getRoomById(id);
        if(room != null) {
            return ResponseEntity.ok().body(room);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    //POST at http://localhost:8080/rooms
    @PostMapping()
    public ResponseEntity<RoomDTO> createRoom(@RequestBody RoomDTO room) {

        if (room == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.createRoom(room);
            return ResponseEntity.ok().body(room);
        }

    }
    //DELETE at http://localhost:XXXX/rooms
    @DeleteMapping("{id}")
    public ResponseEntity<RoomDTO> deleteRoom(@PathVariable("id") String id) {
        if(!id.isEmpty()) {
            service.deleteRoom(id);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }

    //PUT at http://localhost:XXXX/rooms
    @PutMapping()
    public ResponseEntity<RoomDTO> updateRoom(@RequestBody RoomDTO room)
    {
        if(service.editRoom(room))
        {
            return ResponseEntity.ok().body(room);
        }
        else
        {
            return  ResponseEntity.notFound().build();
        }
    }
}