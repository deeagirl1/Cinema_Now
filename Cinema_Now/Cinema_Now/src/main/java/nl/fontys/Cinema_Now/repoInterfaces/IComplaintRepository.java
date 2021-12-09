package nl.fontys.Cinema_Now.repoInterfaces;

import nl.fontys.Cinema_Now.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComplaintRepository extends JpaRepository<Complaint, String> {

}
