package nl.fontys.Cinema_Now.Controllers;

import nl.fontys.Cinema_Now.Modules.Complaint;
import nl.fontys.Cinema_Now.Interfaces.Services.IComplaintService;
import nl.fontys.Cinema_Now.DTO.ComplaintDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private IComplaintService service;

    public ComplaintController(IComplaintService service)
    {
        this.service=service;
    }
    //GET at /movies
    @GetMapping
    public ResponseEntity getAllComplaints()
    {
        List<Complaint> complaints = null;
        complaints = service.getAllComplaint();

        if(complaints != null)
        {
            return ResponseEntity.ok().body(complaints);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
    //GET at movies/action e…g
    @GetMapping("{id}")
    public ResponseEntity getComplaintByID(@PathVariable(value = "id")  int id) {
        ComplaintDTO complaint= service.getComplaint(id);

        if (complaint != null) {
            return ResponseEntity.ok().body(complaint);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    //POST at http://localhost:8080/movies
    @PostMapping()
    public ResponseEntity<Complaint> createComplaint(@RequestBody ComplaintDTO complaint) {
        if (!service.createComplaint(complaint)){
            String entity =  "Complaint  " + complaint.getID()+ " already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {
            String url = "movie" + "/" + complaint.getID(); // url of the created student
            URI uri = URI.create(url);
            return new ResponseEntity(uri,HttpStatus.CREATED);
        }
    }
}


