package nl.fontys.Cinema_Now.service;

import nl.fontys.Cinema_Now.calculators.LoyaltyCalculator;
import nl.fontys.Cinema_Now.converters.TicketConverter;
import nl.fontys.Cinema_Now.dalInterfaces.*;
import nl.fontys.Cinema_Now.model.*;
import nl.fontys.Cinema_Now.model.Enums.TicketType;
import nl.fontys.Cinema_Now.serviceInterface.ITicketService;
import nl.fontys.Cinema_Now.dto.TicketDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;


@Service @Transactional
public class TicketService implements ITicketService {

        private final ITicketDAL data;
        private final TicketConverter converter;
        private final IUserDAL users;
        private final IMovieDAL movies;
        private final IRoomDAL rooms;
        private final IProjectionDAL projections;
        private final LoyaltyCalculator loyalityCalculator = new LoyaltyCalculator();

        @Autowired
        public TicketService(ITicketDAL data, IUserDAL user, IMovieDAL movie, TicketConverter converter, IRoomDAL rooms,IProjectionDAL projections)
        {
            this.data = data;
            this.users = user;
            this.movies = movie;
            this.converter = converter;
            this.rooms = rooms;
            this.projections = projections;
        }

        @Override
        public boolean createTicket(TicketDTO ticket)
        {
            AppUser appUser = this.users.getUserByID(ticket.getHolderId());
            Movie movie = this.movies.getMovie(ticket.getMovieId());
            Room room = this.rooms.getRoomById(ticket.getRoomName());
            Projection projection = this.projections.getProjectionById(ticket.getProjectionId());

            if(appUser != null && movie != null && room != null && projection != null)
            {
                Ticket entity = converter.dtoToEntity(ticket);
                entity.setMovie(movie);
                entity.setHolder(appUser);
                entity.setRoom(room);
                entity.setProjection(projection);
                appUser.getTickets().add(entity);
                data.create(entity);
                loyalityCalculator.AssignLoyaltyToUser(appUser);
                return true;
            }
            else
            {
                throw new NullPointerException();
            }
        }

    @Override
    public List<TicketDTO> getAllTickets()
    {
        return this.converter.entityToDto(data.getAllTickets());
    }

    @Override
    public List<TicketType> getAllTypes() {
        return  Arrays.asList(TicketType.values());
    }

    @Override
    public List<TicketDTO> getTicketsOfUser(String username) {
        return this.converter.entityToDto(data.getTicketsOfUser(username));
    }

    @Override
    public TicketDTO getTicketById(String id) {
        return converter.entityToDto(data.getTicketById(id));
    }

    @Override
    public boolean delete(String id) {
       if(!id.isBlank())
       {
            data.delete(id);
            return true;
       }
        return false;
    }

    @Override
    public List<TicketDTO> getTicketsByMovieId(String movieId) {
        return converter.entityToDto(data.getTicketsByMovieId(movieId));
    }
}
