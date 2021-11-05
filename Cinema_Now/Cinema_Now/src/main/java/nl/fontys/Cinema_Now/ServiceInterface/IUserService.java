package nl.fontys.Cinema_Now.ServiceInterface;

import nl.fontys.Cinema_Now.Model.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    List<User> getAllUsers();
    User getUserByID(String id);
    boolean addUser(User user);
    boolean editUser(User user);
    boolean deleteUser(String id);

}
