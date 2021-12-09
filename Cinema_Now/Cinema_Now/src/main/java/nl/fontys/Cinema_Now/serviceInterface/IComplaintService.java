package nl.fontys.Cinema_Now.serviceInterface;

import nl.fontys.Cinema_Now.model.AppUser;
import nl.fontys.Cinema_Now.dto.ComplaintDTO;

import java.util.List;


public interface IComplaintService {
    List<ComplaintDTO> getAllComplaints();
    ComplaintDTO getComplaint(String id);
    boolean createComplaint(ComplaintDTO complaintDTO);
    ComplaintDTO getComplaintByUser(AppUser appUser);
}
