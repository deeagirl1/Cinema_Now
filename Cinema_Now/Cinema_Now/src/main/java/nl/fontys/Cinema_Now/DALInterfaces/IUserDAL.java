package nl.fontys.Cinema_Now.DALInterfaces;

import nl.fontys.Cinema_Now.Model.User;

import java.util.List;
import java.util.UUID;

public interface IUserDAL {
    List<User> getAllUsers();
    User getUserByID(String id);
//    Role saveRole(Role role);
//    void addRoleToUser(String email,String roleName);
    boolean addUser(User user);
    boolean editUser(User user);
    boolean deleteUser(String id);

}
