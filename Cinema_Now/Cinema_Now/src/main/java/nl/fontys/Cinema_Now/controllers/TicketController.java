package nl.fontys.Cinema_Now.controllers;

import nl.fontys.Cinema_Now.Model.AppUser;
import nl.fontys.Cinema_Now.ServiceInterface.IRoomService;
import nl.fontys.Cinema_Now.ServiceInterface.ITicketService;
import nl.fontys.Cinema_Now.DTO.TicketDTO;
import nl.fontys.Cinema_Now.ServiceInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/ticket")
public class TicketController {

        private ITicketService service;
        private IUserService userService;
        private IRoomService roomService;

    @Autowired
    public TicketController(ITicketService service, IUserService userService, IRoomService roomService)
    {
        this.userService = userService;
        this.service=service;
        this.roomService = roomService;
    }

    @GetMapping()
    public ResponseEntity<List<TicketDTO>>getAllTickets()
    {
        List<TicketDTO> ticketList = service.getAllTickets();

        if(ticketList != null) {
            return ResponseEntity.ok().body(ticketList);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("{id}")
    //DELETE at http://localhost:XXXX/ticket/1
    public ResponseEntity<TicketDTO> deleteTicket(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.ok().build();

    }

    @PostMapping()
    //Method for buying tickets
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO dto) {
        Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
        AppUser loggedInUser = this.userService.getUser(authentication.getName());
        dto.setHolder_id(loggedInUser.getId());
        if (dto != null && roomService.checkCapacity(dto.getRoom_id())) {
            service.createTicket(dto);
            return ResponseEntity.ok().body(dto);

        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
