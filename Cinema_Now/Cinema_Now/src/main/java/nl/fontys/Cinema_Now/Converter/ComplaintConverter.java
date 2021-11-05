package nl.fontys.Cinema_Now.Converter;

import nl.fontys.Cinema_Now.DTO.ComplaintDTO;
import nl.fontys.Cinema_Now.Model.Complaint;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ComplaintConverter {
    public ComplaintDTO entityToDto(Complaint entity)
    {
        ComplaintDTO dto = new ComplaintDTO();

        dto.setContainer(entity.getContainer());
        dto.setSentDate(entity.getSentDate());
        dto.setTitle(entity.getTitle());

        return dto;

    }
    public List<ComplaintDTO> entityToDto(List<Complaint> complaints)
    {
        return complaints.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }
    public Complaint dtoToEntity(ComplaintDTO dto)
    {
        Complaint entity = new Complaint();

        entity.setContainer(dto.getContainer());
        entity.setTitle(dto.getTitle());
        entity.setSentDate(dto.getSentDate());
        return entity;

    }
    public List<Complaint> dtoToEntity(List<ComplaintDTO> complaintDTOS)
    {
        return complaintDTOS.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());

    }
}
