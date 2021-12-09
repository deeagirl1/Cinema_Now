package nl.fontys.Cinema_Now.dalInterfaces;

import nl.fontys.Cinema_Now.model.AppUser;
import nl.fontys.Cinema_Now.model.Role;

import java.util.List;

public interface IUserDAL {
    List<AppUser> getAllUsers();
    AppUser getUserByID(String id);
    AppUser getUser(String username);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    boolean addUser(AppUser appUser);
    AppUser editUser(AppUser appUser);
    boolean deleteUser(String id);

}
