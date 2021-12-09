package nl.fontys.Cinema_Now.repoInterfaces;

import nl.fontys.Cinema_Now.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role,String> {
    Role findByName(String name);
}
