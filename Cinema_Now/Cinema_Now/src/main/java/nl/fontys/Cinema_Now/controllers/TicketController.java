package nl.fontys.Cinema_Now.controllers;

import nl.fontys.Cinema_Now.model.AppUser;
import nl.fontys.Cinema_Now.model.Enums.TicketType;
import nl.fontys.Cinema_Now.serviceInterface.ITicketService;
import nl.fontys.Cinema_Now.dto.TicketDTO;
import nl.fontys.Cinema_Now.serviceInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/ticket")
public class TicketController {

        private final ITicketService service;
        private final IUserService userService;

    @Autowired
    public TicketController(ITicketService service, IUserService userService)
    {
        this.userService = userService;
        this.service=service;
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

    @GetMapping("{movieId}")
    public ResponseEntity<List<TicketDTO>>getTicketsByMovieId(@PathVariable("movieId") String movieId)
    {
        var tickets = service.getTicketsByMovieId(movieId);

        if(tickets != null) {
            return ResponseEntity.ok().body(tickets);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/userTickets/{username}")
    public ResponseEntity<List<TicketDTO>>getUserTickets(@PathVariable("username") String username)
    {
        List<TicketDTO> ticketList = service.getTicketsOfUser(username);

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
        dto.setHolderId(loggedInUser.getId());
        if (service.createTicket(dto)) {
            return ResponseEntity.ok().body(dto);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/ticketTypes")
    public ResponseEntity<List<TicketType>> getTicketTypes() {
        var types = service.getAllTypes();

        if(types != null)
        {
            return ResponseEntity.ok().body(types);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }

}
