package nl.fontys.Cinema_Now.RepoInterfaces;

import nl.fontys.Cinema_Now.Model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComplaintRepository extends JpaRepository<Complaint, String> {
}
