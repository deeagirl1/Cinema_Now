package nl.fontys.Cinema_Now.Services;

import nl.fontys.Cinema_Now.DTO.User;
import nl.fontys.Cinema_Now.Interfaces.Data.IUserData;
import nl.fontys.Cinema_Now.Interfaces.Managers.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
     IUserData userData;

    @Autowired
    public UserService(IUserData userData)
    {
        this.userData = userData;
    }

    @Override
    public List<User> GetAllUsers() {
        return userData.GetAllUsers();
    }

    @Override
    public User GetUserByID(int id) {
        return userData.GetUserByID(id);
    }

    @Override
    public boolean AddUser(User user) {
        return userData.AddUser(user);
    }

    @Override
    public boolean editUser(User user) {
        return userData.editUser(user);
    }

    @Override
    public boolean deleteUser(int id) {
        return userData.deleteUser(id);
    }
}