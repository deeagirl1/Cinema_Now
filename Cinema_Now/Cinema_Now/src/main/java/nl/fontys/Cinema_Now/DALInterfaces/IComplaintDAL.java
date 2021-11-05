package nl.fontys.Cinema_Now.DALInterfaces;

import nl.fontys.Cinema_Now.Model.Complaint;
import nl.fontys.Cinema_Now.DTO.ComplaintDTO;
import nl.fontys.Cinema_Now.Model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IComplaintDAL {
    List<Complaint> getAllComplaint();
    Complaint getComplaint(String id);
    boolean createComplaint(Complaint complaint);
    boolean deleteComplaint(String id);
    Optional<Complaint> getComplaintByUser(User user);
}
