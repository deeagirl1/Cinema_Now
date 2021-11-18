package nl.fontys.Cinema_Now.controllers;

import nl.fontys.Cinema_Now.Converter.ComplaintConverter;
import nl.fontys.Cinema_Now.Model.AppUser;
import nl.fontys.Cinema_Now.Model.Complaint;
import nl.fontys.Cinema_Now.ServiceInterface.IComplaintService;
import nl.fontys.Cinema_Now.DTO.ComplaintDTO;
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
@RequestMapping("/complaint")
public class ComplaintController {

    private IComplaintService service;
    private IUserService userService;
    private ComplaintConverter converter;

    @Autowired
    public ComplaintController(IComplaintService service, ComplaintConverter converter, IUserService userService)
    {
        this.service=service;
        this.converter = converter;
        this.userService = userService;
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
    public ResponseEntity<ComplaintDTO> createComplaintForAuthenticatedUser(@RequestBody ComplaintDTO dto) {  //If the user is logged in, then the sender_id is know, else I want to set the email as being the sender
        Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
        AppUser loggedInUser = this.userService.getUser(authentication.getName());
        dto.setSender_id(loggedInUser.getId());
        if(service.createComplaint(dto))
        {
            return ResponseEntity.noContent().build();
        }
        else
        {
            return new ResponseEntity("Please provide a movie.",HttpStatus.NOT_FOUND);
        }
    }

}


