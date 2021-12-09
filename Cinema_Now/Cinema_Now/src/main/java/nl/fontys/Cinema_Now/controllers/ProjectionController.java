package nl.fontys.Cinema_Now.controllers;

import nl.fontys.Cinema_Now.serviceInterface.IProjectionService;
import nl.fontys.Cinema_Now.dto.ProjectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/projections")
public class ProjectionController {

    private final IProjectionService service;

    @Autowired
    public ProjectionController(IProjectionService service)
    {
        this.service=service;
    }

    //GET at /rooms
    @GetMapping
    public ResponseEntity<List<ProjectionDTO>> getAllProjections()
    {
        List<ProjectionDTO> projections = service.getAllProjections();

        if(projections != null)
        {
            return ResponseEntity.ok().body(projections);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
    //GET at projections/1 e…g
    @GetMapping("{id}")
    public ResponseEntity<ProjectionDTO> getProjectionById(@PathVariable(value = "id")  String id) {
        ProjectionDTO projectionDTO = service.getProjectionById(id);

        if(projectionDTO != null) {
            return ResponseEntity.ok().body(projectionDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping()
    public ResponseEntity<ProjectionDTO> createProjection(@RequestBody ProjectionDTO projectionDTO) {
        if (projectionDTO == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.createProjection(projectionDTO);
            return ResponseEntity.ok().body(projectionDTO);
        }
    }

    @PutMapping()
    public ResponseEntity<ProjectionDTO> updateProjection(@RequestBody ProjectionDTO projectionDTO) {
        if (projectionDTO == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.editProjection(projectionDTO);
            return ResponseEntity.ok().body(projectionDTO);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ProjectionDTO>  deletePost(@PathVariable("id") String id) {
        service.deleteProjection(id);
        return ResponseEntity.ok().build();

    }
}
