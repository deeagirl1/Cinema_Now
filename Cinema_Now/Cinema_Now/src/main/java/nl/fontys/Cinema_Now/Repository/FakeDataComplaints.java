package nl.fontys.Cinema_Now.Repository;

import nl.fontys.Cinema_Now.DTO.Complaint;
import nl.fontys.Cinema_Now.DTO.Enums.Format;
import nl.fontys.Cinema_Now.DTO.Enums.Genre;
import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.DTO.User;
import nl.fontys.Cinema_Now.Interfaces.Data.IComplaintData;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class FakeDataComplaints implements IComplaintData {

    private final List<Complaint> complaints = new ArrayList<>();

    public FakeDataComplaints() {
        User user1 = new User("Andreea", "Sindrilaru", "a.sindrilaru@gmail.ccom", "Boschdijk 42", 20);

        Complaint complaint1 = new Complaint(user1, "Test", "Lorem Ipsum");

        complaints.add(complaint1);

    }

    @Override
    public List<Complaint> GetAllComplaint() {
        return complaints;
    }

    @Override
    public Complaint GetComplaint(int id) {
        for (Complaint complaint : complaints)
        {
            if(complaint.getID() == id)
            {
                return complaint;
            }
        }
        return null;
    }

    @Override
    public boolean CreateComplaint(Complaint complaint) {
        if (this.GetComplaint(complaint.getID()) != null) {
            return false;
        }
        complaints.add(complaint);
        return true;
    }

    @Override
    public List<Complaint> GetComplaintsByFullName(String fullName) {
        List<Complaint> temp = new ArrayList<>();
        for (Complaint complaint : complaints) {
            if (fullName.contains(complaint.getSender())) {
                temp.add(complaint);
            }
        }
        return temp;
    }
}

