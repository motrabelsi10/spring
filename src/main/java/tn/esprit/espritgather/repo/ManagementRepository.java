package tn.esprit.espritgather.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.espritgather.entity.Management;
import tn.esprit.espritgather.entity.Ticket;

import java.util.List;

public interface ManagementRepository extends JpaRepository<Management,Long> {
    Management findManagementByEventIdEvent(Long eventId);
}
