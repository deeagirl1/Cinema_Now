package nl.fontys.Cinema_Now.Repository;

import nl.fontys.Cinema_Now.Modules.Complaint;
import nl.fontys.Cinema_Now.DTO.ComplaintDTO;
import nl.fontys.Cinema_Now.Modules.User;
import nl.fontys.Cinema_Now.Interfaces.Data.IComplaintData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class FakeDataComplaints implements IComplaintData {

    private final List<Complaint> complaints = new ArrayList<>();

    public FakeDataComplaints() {
        User user = new User("Andreea", "Sindrilaru","a.sindrilaru@gmail.ccom","Boschdijk 42", 20);
        Date date = new Date();
        ComplaintDTO complaint1 = new ComplaintDTO("Vaccine required","Dear Sir/Madam, \n From tomorrow vaccination will be required, can I enter with a PCR test?",date,user.getFullName());
        complaints.add(complaint1);

    }

    @Override
    public List<Complaint> getAllComplaint() {
        return complaints;
    }

    @Override
    public ComplaintDTO getComplaint(int id) {
        for (Complaint complaint : complaints)
        {
            if(complaint.getID() == id)
            {
                return (ComplaintDTO) complaint;
            }
        }
        return null;
    }

    @Override
    public boolean createComplaint(ComplaintDTO complaint) {
        if (this.getComplaint(complaint.getID()) != null) {
            return false;
        }
        complaints.add(complaint);
        return true;
    }

    @Override
    public List<ComplaintDTO> getComplaintByUser(User user) {
        List<ComplaintDTO>  temp = new ArrayList<>();
        for(Complaint complaint : complaints)
        {
            if(((ComplaintDTO)complaint).getSender().contains(user.getFullName()))
            {
                temp.add((ComplaintDTO) complaint);
            }
        }
        return temp;
    }
}

