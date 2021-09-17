package nl.fontys.Cinema_Now.Controllers;

import nl.fontys.Cinema_Now.DTO.Complaint;
import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.Repository.FakeDataComplaints;
import nl.fontys.Cinema_Now.Repository.FakeDataMovies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private static final FakeDataComplaints fakeData = new FakeDataComplaints();

    //GET at /movies
    @GetMapping
    public ResponseEntity getAllComplaints()
    {
        List<Complaint> complaints = null;
        complaints = fakeData.getAllComplaint();

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
        Complaint complaint=fakeData.getComplaint(id);

        if (complaint != null) {
            return ResponseEntity.ok().body(complaint);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    //POST at http://localhost:8080/movies
    @PostMapping()
    public ResponseEntity<Complaint> createComplaint(@RequestBody Complaint complaint) {
        if (!fakeData.createComplaint(complaint)){
            String entity =  "Complaint  " + complaint.getID()+ " already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {
            String url = "movie" + "/" + complaint.getID(); // url of the created student
            URI uri = URI.create(url);
            return new ResponseEntity(uri,HttpStatus.CREATED);
        }
    }
}


