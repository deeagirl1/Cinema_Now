package nl.fontys.Cinema_Now.Service;

import nl.fontys.Cinema_Now.Converter.RoomConverter;
import nl.fontys.Cinema_Now.DALInterfaces.IMovieDAL;
import nl.fontys.Cinema_Now.DALInterfaces.IRoomDAL;
import nl.fontys.Cinema_Now.DTO.RoomDTO;
import nl.fontys.Cinema_Now.Model.Movie;
import nl.fontys.Cinema_Now.Model.Room;
import nl.fontys.Cinema_Now.ServiceInterface.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
public class RoomService implements IRoomService {
    IRoomDAL data;
    RoomConverter converter;
    IMovieDAL movies;

    @Autowired
    public RoomService(IRoomDAL data, RoomConverter converter, IMovieDAL movies)
    {

        this.data = data;
        this.converter = converter;
        this.movies = movies;
    }

    @Override
    public List<Room> getAllRooms() {
        return data.getAllRooms();
    }

    @Override
    public Room getRoomById(String id) {
        return data.getRoomById(id);
    }

    @Override
    public boolean createRoom(RoomDTO room){
        Movie movie = this.movies.getMovie(room.getMovie_id());

        if(movie != null && room != null)
        {
            Room entity = converter.dtoToEntity(room);
            entity.setMovie(movie);
            movie.setRoom(entity);
            data.createRoom(entity);
            return true;
        }
        else
        {
            throw new NullPointerException();
        }
    }

    @Override
    public boolean editRoom(RoomDTO room) {
        return editRoom(room);
    }

    @Override
    public boolean deleteRoom(String id) {
        return deleteRoom(id);
    }

    @Override
    public boolean checkCapacity(String id) {
        Room room = this.getRoomById(id);
        if(room.getTickets().size() < room.getCapacity()){
           return true;
       }
        else if(room.getTickets().size() == 0)
        {
            return true;
        }
        return false;

    }
}

