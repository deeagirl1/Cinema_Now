package nl.fontys.Cinema_Now.DALInterfaces;

import nl.fontys.Cinema_Now.Model.AppUser;
import nl.fontys.Cinema_Now.Model.Role;

import java.util.List;

public interface IUserDAL {
    List<AppUser> getAllUsers();
    AppUser getUserByID(String id);
    AppUser getUser(String username);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    boolean addUser(AppUser appUser);
    boolean editUser(AppUser appUser);
    boolean deleteUser(String id);

}
