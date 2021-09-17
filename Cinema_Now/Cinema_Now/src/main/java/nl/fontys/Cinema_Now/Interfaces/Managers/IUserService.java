package nl.fontys.Cinema_Now.Interfaces.Managers;

import nl.fontys.Cinema_Now.DTO.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    User getUserByID(int id);
    boolean addUser(User user);
    boolean editUser(User user);
    boolean deleteUser(int id);

}
