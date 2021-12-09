package nl.fontys.Cinema_Now.converters;

import nl.fontys.Cinema_Now.dto.TicketDTO;
import nl.fontys.Cinema_Now.model.Ticket;
import nl.fontys.Cinema_Now.calculators.TicketCalculator;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketConverter {

    public TicketDTO entityToDto(Ticket ticket)
    {

        TicketDTO dto  = new TicketDTO();
        TicketCalculator calculator = new TicketCalculator(ticket);
        dto.setId(ticket.getId());
        dto.setMovieId(ticket.getMovie().getName());
        dto.setHolderId(ticket.getHolder().getId());
        dto.setProjectionId(ticket.getProjection().getId());
        dto.setType(ticket.getType());
        dto.setRoomName(ticket.getRoom().getName());
        dto.setAmountOfPeople(ticket.getAmountOfPeople());
        dto.setPrice(calculator.calculateTotalTicketPrice());

        return dto;

    }
    public List<TicketDTO> entityToDto(List<Ticket> ticket)
    {
        return ticket.stream().map(this::entityToDto).collect(Collectors.toList());

    }
    public Ticket dtoToEntity(TicketDTO dto)
    {
        Ticket entity = new Ticket();
        TicketCalculator calculator = new TicketCalculator(entity);
        entity.setId(dto.getId());
        entity.setType(dto.getType());
        entity.setPrice(calculator.calculateTotalTicketPrice());
        entity.setAmountOfPeople(dto.getAmountOfPeople());

        return entity;

    }
    public List<Ticket> dtoToEntity(List<TicketDTO> ticket)
    {
        return ticket.stream().map(this::dtoToEntity).collect(Collectors.toList());

    }

}
