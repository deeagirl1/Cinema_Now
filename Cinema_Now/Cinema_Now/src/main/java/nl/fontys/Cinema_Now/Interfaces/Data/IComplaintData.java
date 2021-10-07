package nl.fontys.Cinema_Now.Interfaces.Data;

import nl.fontys.Cinema_Now.Modules.Complaint;
import nl.fontys.Cinema_Now.DTO.ComplaintDTO;
import nl.fontys.Cinema_Now.Modules.User;

import java.util.List;

public interface IComplaintData {
    List<Complaint> getAllComplaint();
    ComplaintDTO getComplaint(int id);
    boolean createComplaint(ComplaintDTO complaint);
    List<ComplaintDTO> getComplaintByUser(User user);
}
