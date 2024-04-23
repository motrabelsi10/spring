package tn.esprit.espritgather.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.espritgather.entity.Management;

public interface ManagementRepository extends JpaRepository<Management,Long> {
}
