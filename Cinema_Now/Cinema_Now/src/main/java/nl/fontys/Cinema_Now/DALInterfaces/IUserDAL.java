package nl.fontys.Cinema_Now.DALInterfaces;

import nl.fontys.Cinema_Now.Model.User;
import java.util.List;

public interface IUserDAL {
    List<User> getAllUsers();
    User getUserByID(String id);
    boolean addUser(User user);
    boolean editUser(User user);
    boolean deleteUser(String id);

}
