package nl.fontys.Cinema_Now.Controllers;

import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.DTO.News;
import nl.fontys.Cinema_Now.DTO.Ticket;
import nl.fontys.Cinema_Now.DTO.User;
import nl.fontys.Cinema_Now.Interfaces.Managers.ITicketService;
import nl.fontys.Cinema_Now.Interfaces.Managers.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

        private ITicketService service;

        @Autowired
        public TicketController(ITicketService service)
        {
            this.service=service;
        }



    @GetMapping("{lastName}")
    public ResponseEntity geTicketsByUser(@PathVariable(value = "lastName") String lastName)
    {
        List<Ticket> ticketList = null;

        ticketList = service.getTicketsOfUser((lastName));

        if(ticketList != null)
        {
            return ResponseEntity.ok().body(ticketList);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping
    public ResponseEntity getAllTickets()
    {
        List<Ticket> ticketList = null;

        ticketList = service.getAllTickets();

        if(ticketList != null)
        {
            return ResponseEntity.ok().body(ticketList);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping()
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        if (!service.createTicket(ticket)){
            String entity =  "Ticket  " + ticket.getTicketID()+ " already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {
            String url = "ticket" + "/" + ticket.getHolder(); // url of the created student
            URI uri = URI.create(url);
            return new ResponseEntity(uri,HttpStatus.CREATED);
        }
    }

    }
