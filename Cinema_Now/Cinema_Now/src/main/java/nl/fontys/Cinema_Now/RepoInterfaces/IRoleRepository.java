package nl.fontys.Cinema_Now.RepoInterfaces;

import nl.fontys.Cinema_Now.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role,String> {
    Role findByName(String name);
}
