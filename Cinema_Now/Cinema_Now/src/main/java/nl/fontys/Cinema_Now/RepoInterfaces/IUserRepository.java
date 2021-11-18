package nl.fontys.Cinema_Now.RepoInterfaces;

import nl.fontys.Cinema_Now.Model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
    AppUser findByEmail(String email);
}
