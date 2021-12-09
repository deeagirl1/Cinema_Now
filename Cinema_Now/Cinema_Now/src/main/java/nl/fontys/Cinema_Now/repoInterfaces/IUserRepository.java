package nl.fontys.Cinema_Now.repoInterfaces;

import nl.fontys.Cinema_Now.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
