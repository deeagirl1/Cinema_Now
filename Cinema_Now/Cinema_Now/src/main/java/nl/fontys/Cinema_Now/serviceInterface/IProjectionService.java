package nl.fontys.Cinema_Now.serviceInterface;

import nl.fontys.Cinema_Now.dto.ProjectionDTO;

import java.util.List;

public interface IProjectionService {
    List<ProjectionDTO> getAllProjections();
    boolean createProjection(ProjectionDTO projection);
    boolean editProjection(ProjectionDTO projection);
    boolean deleteProjection(String id);
    ProjectionDTO getProjectionById(String id);

}
