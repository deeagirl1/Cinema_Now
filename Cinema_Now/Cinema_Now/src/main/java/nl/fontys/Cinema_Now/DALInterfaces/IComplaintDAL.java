package nl.fontys.Cinema_Now.DALInterfaces;

import nl.fontys.Cinema_Now.Model.AppUser;
import nl.fontys.Cinema_Now.Model.Complaint;

import java.util.List;
import java.util.Optional;

public interface IComplaintDAL {
    List<Complaint> getAllComplaint();
    Complaint getComplaint(String id);
    boolean createComplaint(Complaint complaint);
    boolean deleteComplaint(String id);
    Optional<Complaint> getComplaintByUser(AppUser appUser);
}
