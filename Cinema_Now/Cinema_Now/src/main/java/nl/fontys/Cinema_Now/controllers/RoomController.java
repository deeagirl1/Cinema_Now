package nl.fontys.Cinema_Now.controllers;

import nl.fontys.Cinema_Now.DTO.RoomDTO;
import nl.fontys.Cinema_Now.Model.Room;
import nl.fontys.Cinema_Now.ServiceInterface.IMovieService;
import nl.fontys.Cinema_Now.ServiceInterface.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private IRoomService service;
    private IMovieService movieService;

    @Autowired
    public RoomController(IRoomService service, IMovieService movieService)
    {
        this.service=service;
        this.movieService = movieService;
    }

    //GET at /rooms
    @GetMapping
    public ResponseEntity getAllRooms()
    {
        List<Room> rooms = service.getAllRooms();

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
    public ResponseEntity getRoomById(@PathVariable(value = "id")  String id) {
        Room room = service.getRoomById(id);

        if(room != null) {
            return ResponseEntity.ok().body(room);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    //POST at http://localhost:8080/rooms
    @PostMapping()
    public ResponseEntity createRoom(@RequestBody RoomDTO room) {

        if (room == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            service.createRoom(room);
            return ResponseEntity.ok().build();
        }

    }
    //DELETE at http://localhost:XXXX/rooms
    @DeleteMapping("{id}")
    public ResponseEntity deletePost(@PathVariable("id") String id) {
        service.deleteRoom(id);
        return ResponseEntity.ok().build();

    }

    //PUT at http://localhost:XXXX/rooms
    @PutMapping()
    public ResponseEntity updateRoom(@RequestBody RoomDTO room)
    {
        if(service.editRoom(room))
        {
            return ResponseEntity.noContent().build();
        }
        else
        {
            return new ResponseEntity("Please provide a room.",HttpStatus.NOT_FOUND);
        }
    }
}