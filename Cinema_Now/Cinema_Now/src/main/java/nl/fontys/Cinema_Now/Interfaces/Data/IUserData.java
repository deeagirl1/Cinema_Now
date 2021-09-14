package nl.fontys.Cinema_Now.Interfaces.Data;

import nl.fontys.Cinema_Now.DTO.User;

import java.util.List;

public interface IUserData {
    List<User> GetAllUsers();
    User GetUserByID(int id);
    boolean AddUser(User user);

}
