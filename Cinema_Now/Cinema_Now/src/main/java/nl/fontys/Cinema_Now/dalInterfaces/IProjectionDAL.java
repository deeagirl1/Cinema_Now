package nl.fontys.Cinema_Now.dalInterfaces;

import nl.fontys.Cinema_Now.model.Projection;

import java.util.List;

public interface IProjectionDAL {
    List<Projection> getAllProjections();
    boolean createProjection(Projection projection);
    boolean editProjection(Projection projection);
    boolean deleteProjection(String id);
    Projection getProjectionById(String id);

}
