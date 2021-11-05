package nl.fontys.Cinema_Now.Converter;

import nl.fontys.Cinema_Now.DTO.TicketDTO;
import nl.fontys.Cinema_Now.Model.Ticket;
import nl.fontys.Cinema_Now.Calculator.TicketCalculator;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketConverter {

    public TicketDTO entityToDto(Ticket ticket)
    {

        TicketDTO dto  = new TicketDTO();
        TicketCalculator calculator = new TicketCalculator(ticket);
        dto.setMovie_id(ticket.getMovie().getID());
        dto.setHolder_id(ticket.getHolder().getID());
        dto.setDate(ticket.getDate());
        dto.setType(ticket.getType());
        dto.setPrice(calculator.CalculateTotalTicketPrice());

        return dto;

    }
    public List<TicketDTO> entityToDto(List<Ticket> ticket)
    {
        return ticket.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }
    public Ticket dtoToEntity(TicketDTO dto)
    {
        Ticket entity = new Ticket();
        TicketCalculator calculator = new TicketCalculator(entity);

        entity.setDate(dto.getDate());
        entity.setType(dto.getType());
        entity.setPrice(calculator.CalculateTotalTicketPrice());

        return entity;

    }
    public List<Ticket> dtoToEntity(List<TicketDTO> ticket)
    {
        return ticket.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());

    }

}