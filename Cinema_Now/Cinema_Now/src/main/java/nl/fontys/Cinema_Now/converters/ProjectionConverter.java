package nl.fontys.Cinema_Now.converters;

import nl.fontys.Cinema_Now.model.Projection;
import nl.fontys.Cinema_Now.dto.ProjectionDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectionConverter {

    public ProjectionDTO entityToDto(Projection projection)
    {
        ProjectionDTO dto = new ProjectionDTO();
        dto.setId(projection.getId());
        dto.setDate(projection.getDate());
        dto.setTime(projection.getTime());

        return dto;

    }
    public List<ProjectionDTO> entityToDto(List<Projection> projections)
    {
        return projections.stream().map(this::entityToDto).collect(Collectors.toList());

    }
    public Projection dtoToEntity(ProjectionDTO dto)
    {
        Projection entity = new Projection();
        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        entity.setTime(dto.getTime());

        return entity;

    }
    public List<Projection> dtoToEntity(List<ProjectionDTO> projectionsDTOs)
    {
        return projectionsDTOs.stream().map(this::dtoToEntity).collect(Collectors.toList());

    }

}
