package nl.fontys.Cinema_Now.Service;

import nl.fontys.Cinema_Now.Calculator.LoyalityCalculator;
import nl.fontys.Cinema_Now.Converter.TicketConverter;
import nl.fontys.Cinema_Now.DALInterfaces.IMovieDAL;
import nl.fontys.Cinema_Now.DALInterfaces.IRoomDAL;
import nl.fontys.Cinema_Now.DALInterfaces.IUserDAL;
import nl.fontys.Cinema_Now.Model.Movie;
import nl.fontys.Cinema_Now.Model.Room;
import nl.fontys.Cinema_Now.Model.Ticket;
import nl.fontys.Cinema_Now.DALInterfaces.ITicketDAL;
import nl.fontys.Cinema_Now.Model.AppUser;
import nl.fontys.Cinema_Now.ServiceInterface.ITicketService;
import nl.fontys.Cinema_Now.DTO.TicketDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service @Transactional
public class TicketService implements ITicketService {

        private ITicketDAL data;
        private TicketConverter converter;
        private IUserDAL users;
        private IMovieDAL movies;
        private IRoomDAL rooms;
        private LoyalityCalculator loyalityCalculator = new LoyalityCalculator();

        @Autowired
        public TicketService(ITicketDAL data, IUserDAL user, IMovieDAL movie, TicketConverter converter, IRoomDAL rooms)
        {
            this.data = data;
            this.users = user;
            this.movies = movie;
            this.converter = converter;
            this.rooms = rooms;
        }

        @Override
        public boolean createTicket(TicketDTO ticket)
        {
            AppUser appUser = this.users.getUserByID(ticket.getHolder_id());
            Movie movie = this.movies.getMovie(ticket.getMovie_id());
            Room room = this.rooms.getRoomById(ticket.getRoom_id());

            if(appUser != null && movie != null && room != null)
            {
                Ticket entity = converter.dtoToEntity(ticket);
                entity.setMovie(movie);
                entity.setHolder(appUser);
                entity.setRoom(room);
                room.getTickets().add(entity);
                appUser.getTickets().add(entity);
                data.create(entity);
                loyalityCalculator.AssignLoyalityToUser(appUser);
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
    public TicketDTO getTicketByCode(String id) {
        return this.converter.entityToDto(data.getTicketByCode(id));
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
}
