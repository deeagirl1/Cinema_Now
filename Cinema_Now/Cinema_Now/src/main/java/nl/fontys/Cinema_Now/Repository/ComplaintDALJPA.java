package nl.fontys.Cinema_Now.Repository;

import nl.fontys.Cinema_Now.DALInterfaces.IComplaintDAL;
import nl.fontys.Cinema_Now.Model.AppUser;
import nl.fontys.Cinema_Now.Model.Complaint;
import nl.fontys.Cinema_Now.RepoInterfaces.IComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository @Transactional
public class ComplaintDALJPA implements IComplaintDAL {

    private IComplaintRepository repo;

    @Autowired
    public ComplaintDALJPA(IComplaintRepository repo)
    {
        this.repo = repo;
    }

    @Override
    public List<Complaint> getAllComplaint() {

        return repo.findAll();

    }

    @Override
    public Complaint getComplaint(String id) {
        return repo.findById(id).get();
    }

    @Override
    public boolean createComplaint(Complaint complaint) {
        if (complaint != null) {
            repo.save(complaint);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteComplaint(String id) {
        for (Complaint complaint : repo.findAll()) {
            if (complaint.getId().equals(id)) {
                repo.deleteById(id);
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Complaint> getComplaintByUser(AppUser appUser) {
       return repo.findById(appUser.getId());
    }
}
