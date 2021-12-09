package nl.fontys.Cinema_Now.converters;

import nl.fontys.Cinema_Now.dto.ComplaintDTO;
import nl.fontys.Cinema_Now.model.Complaint;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ComplaintConverter {
    public ComplaintDTO entityToDto(Complaint entity)
    {
        ComplaintDTO dto = new ComplaintDTO();
        dto.setId(entity.getId());
        dto.setSender(entity.getSender().getEmail());
        dto.setContainer(entity.getContainer());
        dto.setTitle(entity.getTitle());
        dto.setSentDate(entity.getSentDate());

        return dto;

    }
    public List<ComplaintDTO> entityToDto(List<Complaint> complaints)
    {
        return complaints.stream().map(this::entityToDto).collect(Collectors.toList());

    }
    public Complaint dtoToEntity(ComplaintDTO dto)
    {
        Complaint entity = new Complaint();
        entity.setId(dto.getId());
        entity.setContainer(dto.getContainer());
        entity.setTitle(dto.getTitle());
        entity.setSentDate(dto.getSentDate());
        return entity;

    }
    public List<Complaint> dtoToEntity(List<ComplaintDTO> complaintDTOS)
    {
        return complaintDTOS.stream().map(this::dtoToEntity).collect(Collectors.toList());

    }
}
