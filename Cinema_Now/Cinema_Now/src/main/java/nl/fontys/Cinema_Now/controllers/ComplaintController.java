package nl.fontys.Cinema_Now.controllers;

import nl.fontys.Cinema_Now.model.AppUser;
import nl.fontys.Cinema_Now.serviceInterface.IComplaintService;
import nl.fontys.Cinema_Now.dto.ComplaintDTO;
import nl.fontys.Cinema_Now.serviceInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    private final IComplaintService service;
    private final IUserService userService;


    @Autowired
    public ComplaintController(IComplaintService service, IUserService userService)
    {
        this.service=service;
        this.userService = userService;
    }
    //GET at /movies
    @GetMapping
    public ResponseEntity<List<ComplaintDTO>> getAllComplaints()
    {
        List<ComplaintDTO> complaints =service.getAllComplaints();

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
    public ResponseEntity<ComplaintDTO> getComplaintByID(@PathVariable(value = "id") String id) {
        ComplaintDTO complaint= service.getComplaint(id);
        if (complaint != null) {
            return ResponseEntity.ok().body(complaint);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    //POST at http://localhost:8080/movies
    @PostMapping
    public ResponseEntity<ComplaintDTO> createComplaintForAuthenticatedUser(@RequestBody ComplaintDTO dto) {
        Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
        AppUser loggedInUser = this.userService.getUser(authentication.getName());
        dto.setSender(loggedInUser.getId());
        if(service.createComplaint(dto))
        {

            return ResponseEntity.ok().body(dto);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }


}


