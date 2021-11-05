package nl.fontys.Cinema_Now.Service;

import nl.fontys.Cinema_Now.Converter.TicketConverter;
import nl.fontys.Cinema_Now.DALInterfaces.IMovieDAL;
import nl.fontys.Cinema_Now.DALInterfaces.IUserDAL;
import nl.fontys.Cinema_Now.Model.Movie;
import nl.fontys.Cinema_Now.Model.Ticket;
import nl.fontys.Cinema_Now.DALInterfaces.ITicketDAL;
import nl.fontys.Cinema_Now.Model.User;
import nl.fontys.Cinema_Now.ServiceInterface.ITicketService;
import nl.fontys.Cinema_Now.DTO.TicketDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TicketService implements ITicketService {

        private ITicketDAL data;
        private TicketConverter converter;
        private IUserDAL users;
        private IMovieDAL movies;

        @Autowired
        public TicketService(ITicketDAL data, IUserDAL user, IMovieDAL movie, TicketConverter converter )
        {
            this.data = data;
            this.users = user;
            this.movies = movie;
            this.converter = converter;
        }


        @Override
        public boolean createTicket(TicketDTO ticket) {
            User user = this.users.getUserByID(ticket.getHolder_id());
            Movie movie = this.movies.getMovie(ticket.getMovie_id());

            if(user != null && movie != null)
            {
                Ticket entity = converter.dtoToEntity(ticket);
                entity.setMovie(movie);
                entity.setHolder(user);
                data.create(entity);
                user.getTicketList().add(entity.getId());
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
       if(id != null)
       {
            data.delete(id);
            return true;
       }

        return false;
    }


}
