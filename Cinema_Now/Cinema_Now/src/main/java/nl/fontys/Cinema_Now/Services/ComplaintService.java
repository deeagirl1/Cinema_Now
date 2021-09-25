package nl.fontys.Cinema_Now.Services;

import nl.fontys.Cinema_Now.DTO.Complaint;
import nl.fontys.Cinema_Now.DTO.User;
import nl.fontys.Cinema_Now.Interfaces.Data.IComplaintData;
import nl.fontys.Cinema_Now.Interfaces.Data.IMovieData;
import nl.fontys.Cinema_Now.Interfaces.Managers.IComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService implements IComplaintService {
    private IComplaintData complaintData;

    @Autowired
    public ComplaintService(IComplaintData complaintData)
    {
        this.complaintData = complaintData;
    }

    @Override
    public List<Complaint> getAllComplaint() {
        return complaintData.getAllComplaint();
    }

    @Override
    public Complaint getComplaint(int id) {
        return complaintData.getComplaint(id);
    }

    @Override
    public boolean createComplaint(Complaint complaint) {
        return complaintData.createComplaint(complaint);
    }

    @Override
    public List<Complaint> getComplaintByUser(User user) {
        return complaintData.getComplaintByUser(user);
    }
}
