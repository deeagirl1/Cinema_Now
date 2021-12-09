package nl.fontys.Cinema_Now.repository;

import nl.fontys.Cinema_Now.dalInterfaces.IProjectionDAL;
import nl.fontys.Cinema_Now.model.Projection;
import nl.fontys.Cinema_Now.repoInterfaces.IProjectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProjectionDALJPA implements IProjectionDAL {

    private final IProjectionRepository repo;

    @Autowired
    public ProjectionDALJPA(IProjectionRepository repo)
    {
        this.repo = repo;
    }

    @Override
    public List<Projection> getAllProjections() {
        return repo.findAll();
    }

    @Override
    public Projection getProjectionById(String id) {
        return repo.getById(id);
    }

    @Override
    public boolean createProjection(Projection projection) {
        if(projection != null) {
            repo.save(projection);
            return true;
        }
        return false;
    }

    @Override
    public boolean editProjection(Projection projection) {
        Projection updateProjection = this.getProjectionById(projection.getId());
        if(updateProjection != null) {
            updateProjection.setDate(projection.getDate());
            updateProjection.setTime((projection.getTime()));
            repo.save(updateProjection);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProjection(String id) {
        if(this.getProjectionById(id) != null) {
            for (Projection projection : repo.findAll()) {
                if (projection.getId().equals(id)) {
                    repo.deleteById(id);
                    return true;
                }
            }
        }
        return false;
    }


}
