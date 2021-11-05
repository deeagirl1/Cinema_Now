package nl.fontys.Cinema_Now.Service;

import nl.fontys.Cinema_Now.Converter.UserConverter;
import nl.fontys.Cinema_Now.DTO.UserDTO;
import nl.fontys.Cinema_Now.Model.Movie;
import nl.fontys.Cinema_Now.Model.User;
import nl.fontys.Cinema_Now.DALInterfaces.IUserDAL;
import nl.fontys.Cinema_Now.ServiceInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    private IUserDAL dal;
    private UserConverter converter;
    @Autowired
    public UserService(IUserDAL userData, UserConverter converter)
    {
        this.dal = userData;
        this.converter = converter;
    }

    @Override
    public List<User> getAllUsers() {
        return dal.getAllUsers();
    }

    @Override
    public User getUserByID(String id) {
        return dal.getUserByID(id);
    }

    @Override
    public boolean addUser(UserDTO user) {
        if(user != null)
        {
            User entity = converter.dtoToEntity(user);
            dal.addUser(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean editUser(UserDTO user) {
        if(user != null)
        {
            User entity = converter.dtoToEntity(user);
            dal.editUser(entity);
            return true;
        }
        return false;
    }
    @Override
    public boolean deleteUser(String id) {
        return dal.deleteUser(id);
    }


}