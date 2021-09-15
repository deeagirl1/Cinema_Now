package nl.fontys.Cinema_Now.Interfaces.Data;

import nl.fontys.Cinema_Now.DTO.Complaint;
import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.DTO.User;

import java.util.List;

public interface IComplaintData {
    List<Complaint> GetAllComplaint();
    Complaint GetComplaint(int id);
    boolean CreateComplaint(Complaint complaint);
    List<Complaint> GetComplaintByUser(User user);
}
