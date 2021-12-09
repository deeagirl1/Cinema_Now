package nl.fontys.Cinema_Now.converters;

import nl.fontys.Cinema_Now.model.Complaint;
import nl.fontys.Cinema_Now.model.Ticket;
import nl.fontys.Cinema_Now.dto.UserDTO;
import nl.fontys.Cinema_Now.model.AppUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    public UserDTO entityToDto(AppUser appUser)
    {

        UserDTO dto  = new UserDTO();
        dto.setUsername(appUser.getUsername());
        dto.setEmail(appUser.getEmail());
        dto.setId(appUser.getId());
        dto.setFirstName(appUser.getFirstName());
        dto.setPassword(appUser.getPassword());
        dto.setLastName(appUser.getLastName());
        dto.setLoyal(appUser.isLoyal());

        for (Complaint complaint: appUser.getComplaints()) {
            if(complaint.getSender().equals(appUser))
                dto.getComplaints().add(complaint.getTitle());
        }
        for (Ticket ticket: appUser.getTickets()) {
            if(ticket.getHolder().equals(appUser))
                dto.getTickets().add(ticket.getProjection().getDate());
        }

        return dto;

    }
    public List<UserDTO> entityToDto(List<AppUser> appUsers)
    {
        return appUsers.stream().map(this::entityToDto).collect(Collectors.toList());

    }
    public AppUser dtoToEntity(UserDTO dto)
    {
        ModelMapper mapper = new ModelMapper();

        return mapper.map(dto, AppUser.class);

    }
    public List<AppUser> dtoToEntity(List<UserDTO> userDTOS)
    {
        return userDTOS.stream().map(this::dtoToEntity).collect(Collectors.toList());

    }


}
