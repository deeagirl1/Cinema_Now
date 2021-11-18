package nl.fontys.Cinema_Now.Converter;

import nl.fontys.Cinema_Now.DTO.ComplaintDTO;
import nl.fontys.Cinema_Now.DTO.MovieDTO;
import nl.fontys.Cinema_Now.Model.Complaint;
import nl.fontys.Cinema_Now.Model.News;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ComplaintConverter {
    public ComplaintDTO entityToDto(Complaint entity)
    {
        ModelMapper mapper = new ModelMapper();
        ComplaintDTO dto = mapper.map(entity,ComplaintDTO.class);

        return dto;

    }
    public List<ComplaintDTO> entityToDto(List<Complaint> complaints)
    {
        return complaints.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }
    public Complaint dtoToEntity(ComplaintDTO dto)
    {
        ModelMapper mapper = new ModelMapper();
        Complaint entity = mapper.map(dto,Complaint.class);
        entity.setSentDate(dto.getSentDate());
        return entity;

    }
    public List<Complaint> dtoToEntity(List<ComplaintDTO> complaintDTOS)
    {
        return complaintDTOS.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());

    }
}
