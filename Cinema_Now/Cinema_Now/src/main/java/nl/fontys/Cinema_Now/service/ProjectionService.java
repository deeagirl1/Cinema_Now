package nl.fontys.Cinema_Now.service;


import nl.fontys.Cinema_Now.converters.ProjectionConverter;
import nl.fontys.Cinema_Now.dalInterfaces.IProjectionDAL;
import nl.fontys.Cinema_Now.model.Projection;
import nl.fontys.Cinema_Now.serviceInterface.IProjectionService;
import nl.fontys.Cinema_Now.dto.ProjectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProjectionService implements IProjectionService {

    private final IProjectionDAL data;
    private final ProjectionConverter converter;


    @Autowired
    public ProjectionService(IProjectionDAL data, ProjectionConverter converter)
    {
        this.data = data;
        this.converter = converter;

    }

    @Override
    public List<ProjectionDTO> getAllProjections() {
        return converter.entityToDto(data.getAllProjections());
    }

    @Override
    public boolean createProjection(ProjectionDTO projection) {
        if(projection != null)
        {
            Projection entity = converter.dtoToEntity(projection);
            data.createProjection(entity);
            return true;
        }
        return false;
    }
    @Override
    public boolean editProjection(ProjectionDTO projection) {
         Projection oldEntity = data.getProjectionById(projection.getId());
         if(oldEntity != null)
         {
             Projection newEntity = new Projection(
                     projection.getId(),
                     projection.getTime(),
                     projection.getDate()
             );

             data.editProjection(newEntity);
             return true;
         }
         return false;
    }

    @Override
    public boolean deleteProjection(String id) {
        if(!id.isBlank()) {
            data.deleteProjection(id);
            return true;
        }
        return false;
    }

    @Override
    public ProjectionDTO getProjectionById(String id) {
        return converter.entityToDto(data.getProjectionById(id));
    }


}
