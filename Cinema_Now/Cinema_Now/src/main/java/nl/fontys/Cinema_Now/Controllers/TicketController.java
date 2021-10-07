package nl.fontys.Cinema_Now.Controllers;

import nl.fontys.Cinema_Now.Modules.Ticket;
import nl.fontys.Cinema_Now.Interfaces.Services.ITicketService;
import nl.fontys.Cinema_Now.DTO.TicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/tickets")
public class TicketController {

        private ITicketService service;

        @Autowired
        public TicketController(ITicketService service)
        {
            this.service=service;
        }



//    @GetMapping("{lastName}")
//    public ResponseEntity geTicketsByUser(@PathVariable(value = "lastName") String lastName)
//    {
//        List<Ticket> ticketList = null;
//
//        ticketList = service.getTicketsOfUser((lastName));
//
//        if(ticketList != null)
//        {
//            return ResponseEntity.ok().body(ticketList);
//        }
//        else
//        {
//            return ResponseEntity.notFound().build();
//        }
//
//    }
    @GetMapping()
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
    //Method for buying tickets
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticket) {
        if (!service.createTicket(ticket)){
            String entity =  "Ticket  " + ticket.getTicketID()+ " already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {
            String url = "ticket" + "/" + ticket.getTicketID(); // url of the created ticket
            URI uri = URI.create(url);
            return new ResponseEntity(uri,HttpStatus.CREATED);
        }
    }

    }
