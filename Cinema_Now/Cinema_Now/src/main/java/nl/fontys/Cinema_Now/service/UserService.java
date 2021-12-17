package nl.fontys.Cinema_Now.service;

import nl.fontys.Cinema_Now.converters.UserConverter;
import nl.fontys.Cinema_Now.dto.UserDTO;
import nl.fontys.Cinema_Now.model.AppUser;
import nl.fontys.Cinema_Now.dalInterfaces.IUserDAL;
import nl.fontys.Cinema_Now.model.Role;
import nl.fontys.Cinema_Now.serviceInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
public class UserService implements IUserService {

    private final IUserDAL dal;
    private final UserConverter converter;

    @Autowired
    public UserService(IUserDAL userData, UserConverter converter)
    {
        this.dal = userData;
        this.converter = converter;
    }

    @Override
    public List<AppUser> getAllUsers() {
        return dal.getAllUsers();
    }

    @Override
    public AppUser getUserByID(String id) {
        return dal.getUserByID(id);
    }

    @Override
    public boolean addUser(UserDTO user)  {
        if(user != null)
        {
            AppUser entity = converter.dtoToEntity(user);
            dal.addUser(entity);
            return true;
        }
        return false;
    }

    @Override
    public AppUser getUser(String username) {
        return dal.getUser(username);
    }

    @Override
    public Role saveRole(Role role) {
        return dal.saveRole(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        dal.addRoleToUser(username,roleName);
    }

    @Override
    public AppUser editUser(UserDTO user){
        if(user != null) {
            AppUser updatedAppUser = this.getUserByID(user.getId());
            if (updatedAppUser != null) {
                updatedAppUser.setFirstName(user.getFirstName());
                updatedAppUser.setLastName(user.getLastName());
                updatedAppUser.setEmail(user.getEmail());
                updatedAppUser.setAddress(user.getAddress());
                updatedAppUser.setUsername(user.getUsername());
                updatedAppUser.setAge(user.getAge());

                return dal.editUser(updatedAppUser);
            }
        }
        return null;
    }
    @Override
    public boolean deleteUser(String id) {
        return dal.deleteUser(id);
    }


}