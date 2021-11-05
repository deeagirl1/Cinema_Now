package nl.fontys.Cinema_Now.RepoInterfaces;

import nl.fontys.Cinema_Now.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
