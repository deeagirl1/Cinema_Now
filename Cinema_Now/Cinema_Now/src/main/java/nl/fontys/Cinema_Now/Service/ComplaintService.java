package nl.fontys.Cinema_Now.Service;

import nl.fontys.Cinema_Now.Converter.ComplaintConverter;
import nl.fontys.Cinema_Now.DALInterfaces.IUserDAL;
import nl.fontys.Cinema_Now.Model.AppUser;
import nl.fontys.Cinema_Now.Model.Complaint;
import nl.fontys.Cinema_Now.DTO.ComplaintDTO;
import nl.fontys.Cinema_Now.DALInterfaces.IComplaintDAL;
import nl.fontys.Cinema_Now.ServiceInterface.IComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service @Transactional
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
    public boolean createComplaint(ComplaintDTO dto) {
        AppUser appUser = this.users.getUserByID(dto.getSender());
        if(appUser != null)
        {
            Complaint entity = converter.dtoToEntity(dto);
            entity.setSender(appUser);
            appUser.getComplaints().add(entity);
            complaintData.createComplaint(entity);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Complaint> getComplaintByUser(AppUser appUser) {
        return complaintData.getComplaintByUser(appUser);
    }
}
