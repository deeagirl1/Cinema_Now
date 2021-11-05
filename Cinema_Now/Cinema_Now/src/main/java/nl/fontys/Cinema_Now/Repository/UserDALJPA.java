package nl.fontys.Cinema_Now.Repository;

import nl.fontys.Cinema_Now.DALInterfaces.IUserDAL;
import nl.fontys.Cinema_Now.Model.User;
import nl.fontys.Cinema_Now.RepoInterfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDALJPA implements IUserDAL {

    @Autowired
    IUserRepository repo;

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public User getUserByID(String id) {
        return repo.findById(id).get();
    }

//    @Override
//    public Role saveRole(Role role) {
//        return roleRepo.save(role);
//    }

//    @Override
//    public void addRoleToUser(String email, String roleName) {
//        User user = repo.findByEmail(email);
//        Role role = roleRepo.findByName(roleName);
//        user.getRoles().add(role);
//    }

    @Override
    public boolean addUser(User user) {
        repo.save(user);
        return true;
    }

    @Override
    public boolean editUser(User user) {
        User updatedUser = this.getUserByID(user.getID());
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setAddress(user.getAddress());
        updatedUser.setAge(user.getAge());

        repo.save(updatedUser);
        return true;
    }

    @Override
    public boolean deleteUser(String id) {
         repo.deleteById(id);
         return true;
    }



}
