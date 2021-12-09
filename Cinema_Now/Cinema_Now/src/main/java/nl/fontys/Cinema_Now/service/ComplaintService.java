package nl.fontys.Cinema_Now.service;

import nl.fontys.Cinema_Now.converters.ComplaintConverter;
import nl.fontys.Cinema_Now.dalInterfaces.IUserDAL;
import nl.fontys.Cinema_Now.model.AppUser;
import nl.fontys.Cinema_Now.model.Complaint;
import nl.fontys.Cinema_Now.dto.ComplaintDTO;
import nl.fontys.Cinema_Now.dalInterfaces.IComplaintDAL;
import nl.fontys.Cinema_Now.serviceInterface.IComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


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
    public List<ComplaintDTO> getAllComplaints() {
        return this.converter.entityToDto(complaintData.getAllComplaints());
    }

    @Override
    public ComplaintDTO getComplaint(String id) {
        if(!id.isBlank()) {
            return this.converter.entityToDto(complaintData.getComplaint(id));
        }
        return null;
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
    public ComplaintDTO getComplaintByUser(AppUser appUser) {
        if(appUser != null) {
            return converter.entityToDto(complaintData.getComplaintByUser(appUser));
        }
        return null;
    }
}
