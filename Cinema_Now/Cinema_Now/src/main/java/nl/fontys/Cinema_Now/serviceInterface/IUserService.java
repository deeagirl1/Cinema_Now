package nl.fontys.Cinema_Now.serviceInterface;

import nl.fontys.Cinema_Now.dto.UserDTO;
import nl.fontys.Cinema_Now.model.AppUser;
import nl.fontys.Cinema_Now.model.Role;

import java.util.List;


public interface IUserService {
    List<AppUser> getAllUsers();
    AppUser getUserByID(String id);
    boolean addUser(UserDTO user);
    AppUser getUser(String username);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    AppUser editUser(UserDTO user);
    boolean deleteUser(String id);

}
