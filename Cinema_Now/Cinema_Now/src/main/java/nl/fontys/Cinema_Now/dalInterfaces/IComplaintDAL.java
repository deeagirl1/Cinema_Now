package nl.fontys.Cinema_Now.dalInterfaces;

import nl.fontys.Cinema_Now.model.AppUser;
import nl.fontys.Cinema_Now.model.Complaint;

import java.util.List;

public interface IComplaintDAL {
    List<Complaint> getAllComplaints();
    Complaint getComplaint(String id);
    boolean createComplaint(Complaint complaint);
    boolean deleteComplaint(String id);
    Complaint getComplaintByUser(AppUser appUser);
}
