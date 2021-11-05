package nl.fontys.Cinema_Now.Service;

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
    @Autowired
    public UserService(IUserDAL userData)
    {
        this.dal = userData;
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
    public boolean addUser(User user) {
        return dal.addUser(user);
    }

    @Override
    public boolean editUser(User user) {
        return dal.editUser(user);
    }
    @Override
    public boolean deleteUser(String id) {
        return dal.deleteUser(id);
    }


}