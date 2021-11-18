package nl.fontys.Cinema_Now.Service;

import nl.fontys.Cinema_Now.Converter.UserConverter;
import nl.fontys.Cinema_Now.DTO.UserDTO;
import nl.fontys.Cinema_Now.Model.AppUser;
import nl.fontys.Cinema_Now.DALInterfaces.IUserDAL;
import nl.fontys.Cinema_Now.Model.Role;
import nl.fontys.Cinema_Now.ServiceInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
public class UserService implements IUserService {

    private IUserDAL dal;
    private UserConverter converter;

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
    public boolean addUser(UserDTO user) {
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
    public boolean editUser(UserDTO user) {
        if(user != null)
        {
            AppUser entity = converter.dtoToEntity(user);
            dal.editUser(entity);
            return true;
        }
        return false;
    }
    @Override
    public boolean deleteUser(String id) {
        return dal.deleteUser(id);
    }


}