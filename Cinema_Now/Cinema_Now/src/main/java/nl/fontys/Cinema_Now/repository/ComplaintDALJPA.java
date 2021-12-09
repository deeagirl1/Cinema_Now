package nl.fontys.Cinema_Now.repository;

import nl.fontys.Cinema_Now.dalInterfaces.IComplaintDAL;
import nl.fontys.Cinema_Now.model.AppUser;
import nl.fontys.Cinema_Now.model.Complaint;
import nl.fontys.Cinema_Now.repoInterfaces.IComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository @Transactional
public class ComplaintDALJPA implements IComplaintDAL {

    private IComplaintRepository repo;

    @Autowired
    public ComplaintDALJPA(IComplaintRepository repo)
    {
        this.repo = repo;
    }

    @Override
    public List<Complaint> getAllComplaints() {

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
    public Complaint getComplaintByUser(AppUser appUser) {
       return repo.findById(appUser.getId()).get();
    }
}
