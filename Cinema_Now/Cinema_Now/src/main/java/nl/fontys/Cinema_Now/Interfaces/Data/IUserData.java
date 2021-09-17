package nl.fontys.Cinema_Now.Interfaces.Data;

import nl.fontys.Cinema_Now.DTO.News;
import nl.fontys.Cinema_Now.DTO.User;

import java.util.List;

public interface IUserData {
    List<User> getAllUsers();
    User getUserByID(int id);
    boolean addUser(User user);
    boolean editUser(User user);
    boolean deleteUser(int id);

}
