package nl.fontys.Cinema_Now.Controller;

import nl.fontys.Cinema_Now.Converter.TicketConverter;
import nl.fontys.Cinema_Now.Model.Ticket;
import nl.fontys.Cinema_Now.ServiceInterface.ITicketService;
import nl.fontys.Cinema_Now.DTO.TicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/ticket")
public class TicketController {

        private ITicketService service;



    @Autowired
    public TicketController(ITicketService service)
    {
        this.service=service;
    }

//        @GetMapping("{userID}")
//    public ResponseEntity getTicketsByUser(@PathVariable(value = "lastName") Long userID)
//    {
//        List<Ticket> ticketList = null;
//
//        ticketList = service.getTicketsOfUser((userID));
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
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketDTO dto) {
        if (dto == null) {
            return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
        } else {
            service.createTicket(dto);
            return ResponseEntity.ok().build();
        }


    }

    }
