package nl.fontys.Cinema_Now.Service;

import nl.fontys.Cinema_Now.Converter.ComplaintConverter;
import nl.fontys.Cinema_Now.DALInterfaces.IUserDAL;
import nl.fontys.Cinema_Now.Model.Complaint;
import nl.fontys.Cinema_Now.DTO.ComplaintDTO;
import nl.fontys.Cinema_Now.Model.User;
import nl.fontys.Cinema_Now.DALInterfaces.IComplaintDAL;
import nl.fontys.Cinema_Now.ServiceInterface.IComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ComplaintService implements IComplaintService {
    private IComplaintDAL complaintData;
    private IUserDAL users;
    private ComplaintConverter converter;

    @Autowired
    public ComplaintService(IComplaintDAL complaintData, IUserDAL users, ComplaintConverter converter )
    {
        this.complaintData = complaintData;
        this.users = users;
        this.converter = converter;
    }

    @Override
    public List<ComplaintDTO> getAllComplaint() {
        return this.converter.entityToDto(complaintData.getAllComplaint());
    }

    @Override
    public ComplaintDTO getComplaint(String id) {
        return this.converter.entityToDto(complaintData.getComplaint(id));
    }


    @Override
    public boolean createComplaint(ComplaintDTO complaint) {
        User user = this.users.getUserByID(complaint.getSender_id());
        if(user != null)
        {
            Complaint entity = converter.dtoToEntity(complaint);
            entity.setSender(user);
            complaintData.createComplaint(entity);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Complaint> getComplaintByUser(User user) {
        return complaintData.getComplaintByUser(user);
    }
}
