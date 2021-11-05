package nl.fontys.Cinema_Now.Controller;

import nl.fontys.Cinema_Now.Converter.ComplaintConverter;
import nl.fontys.Cinema_Now.Model.Complaint;
import nl.fontys.Cinema_Now.ServiceInterface.IComplaintService;
import nl.fontys.Cinema_Now.DTO.ComplaintDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    private IComplaintService service;
    private ComplaintConverter converter;
    @Autowired
    public ComplaintController(IComplaintService service, ComplaintConverter converter)
    {
        this.service=service;
        this.converter = converter;
    }
    //GET at /movies
    @GetMapping
    public ResponseEntity getAllComplaints()
    {
        List<Complaint> complaints =this.converter.dtoToEntity(service.getAllComplaint());

        if(complaints != null)
        {
            return ResponseEntity.ok().body(converter.entityToDto(complaints));
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
    //GET at movies/action e…g
    @GetMapping("{id}")
    public ResponseEntity getComplaintByID(@PathVariable(value = "id") String id) {
        Complaint complaint= this.converter.dtoToEntity(service.getComplaint(id));

        if (complaint != null) {
            return ResponseEntity.ok().body(converter.entityToDto(complaint));
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    //POST at http://localhost:8080/movies
    @PostMapping()
    public ResponseEntity<ComplaintDTO> createComplaint(@RequestBody ComplaintDTO dto) {
        Complaint complaint = converter.dtoToEntity(dto);

        if (!service.createComplaint(dto)){
            String path =  "Complaint  " + complaint.getID()+ " already exists.";
            return new ResponseEntity(path, HttpStatus.CONFLICT);
        } else {
            String url = "complaint" + "/" + complaint.getID();
            URI uri = URI.create(url);
            return new ResponseEntity(uri,HttpStatus.CREATED);
        }
    }
}


