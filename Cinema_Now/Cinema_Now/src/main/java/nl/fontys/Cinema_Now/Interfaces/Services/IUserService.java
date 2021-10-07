package nl.fontys.Cinema_Now.Interfaces.Services;

import nl.fontys.Cinema_Now.Modules.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getUserByID(int id);
    boolean addUser(User user);
    boolean editUser(User user);
    boolean deleteUser(int id);

}
