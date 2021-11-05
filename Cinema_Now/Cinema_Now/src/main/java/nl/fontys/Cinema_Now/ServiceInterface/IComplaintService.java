package nl.fontys.Cinema_Now.ServiceInterface;

import nl.fontys.Cinema_Now.Model.Complaint;
import nl.fontys.Cinema_Now.DTO.ComplaintDTO;
import nl.fontys.Cinema_Now.Model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IComplaintService {
    List<ComplaintDTO> getAllComplaint();
    ComplaintDTO getComplaint(String id);
    boolean createComplaint(ComplaintDTO complaintDTO);
    Optional<Complaint> getComplaintByUser(User user);
}
