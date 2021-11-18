package nl.fontys.Cinema_Now.ServiceInterface;

import nl.fontys.Cinema_Now.DTO.UserDTO;
import nl.fontys.Cinema_Now.Model.AppUser;
import nl.fontys.Cinema_Now.Model.Role;

import java.util.List;


public interface IUserService {
    List<AppUser> getAllUsers();
    AppUser getUserByID(String id);
    boolean addUser(UserDTO user);
    AppUser getUser(String username);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    boolean editUser(UserDTO user);
    boolean deleteUser(String id);

}
