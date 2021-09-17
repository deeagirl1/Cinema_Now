package nl.fontys.Cinema_Now.Interfaces.Managers;

import nl.fontys.Cinema_Now.DTO.User;

import java.util.List;

public interface IUserService {
    List<User> GetAllUsers();
    User GetUserByID(int id);
    boolean AddUser(User user);
    boolean editUser(User user);
    boolean deleteUser(int id);

}
