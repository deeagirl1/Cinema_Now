package nl.fontys.Cinema_Now.repository;

import nl.fontys.Cinema_Now.dalInterfaces.IUserDAL;
import nl.fontys.Cinema_Now.model.AppUser;
import nl.fontys.Cinema_Now.model.Role;
import nl.fontys.Cinema_Now.repoInterfaces.IRoleRepository;
import nl.fontys.Cinema_Now.repoInterfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository @Transactional
public class UserDALJPA implements IUserDAL, UserDetailsService {


    private final IUserRepository repo;
    private final IRoleRepository roleRepo;
    private final PasswordEncoder encoder;

    @Autowired
    public UserDALJPA(IUserRepository userRepository, IRoleRepository roleRepository, PasswordEncoder encoder)
    {
        this.repo = userRepository;
        this.roleRepo = roleRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = repo.findByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("User not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

    @Override
    public List<AppUser> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public AppUser getUserByID(String id) {
        return repo.findById(id).get();
    }

    @Override
    public AppUser getUser(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = repo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        appUser.getRoles().add(role);
    }

    @Override
    public boolean addUser(AppUser appUser) {
        appUser.setPassword(encoder.encode(appUser.getPassword()));
        repo.save(appUser);
        return true;
    }

    @Override
    public AppUser editUser(AppUser appUser) {
        return repo.save(appUser);
    }

    @Override
    public boolean deleteUser(String id) {
        if(this.getUserByID(id) != null) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }



}
