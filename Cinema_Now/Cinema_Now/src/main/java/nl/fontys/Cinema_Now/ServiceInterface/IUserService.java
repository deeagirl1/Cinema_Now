package nl.fontys.Cinema_Now.ServiceInterface;

import nl.fontys.Cinema_Now.DTO.UserDTO;
import nl.fontys.Cinema_Now.Model.User;
import java.util.List;


public interface IUserService {
    List<User> getAllUsers();
    User getUserByID(String id);
    boolean addUser(UserDTO user);
    boolean editUser(UserDTO user);
    boolean deleteUser(String id);

}
