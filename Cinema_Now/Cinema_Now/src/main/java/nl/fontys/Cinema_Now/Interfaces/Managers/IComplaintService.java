package nl.fontys.Cinema_Now.Interfaces.Managers;

import nl.fontys.Cinema_Now.DTO.Complaint;
import nl.fontys.Cinema_Now.DTO.User;

import java.util.List;

public interface IComplaintService {
    List<Complaint> getAllComplaint();
    Complaint getComplaint(int id);
    boolean createComplaint(Complaint complaint);
    List<Complaint> getComplaintByUser(User user);
}
