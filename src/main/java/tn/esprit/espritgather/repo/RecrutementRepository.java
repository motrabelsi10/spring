package tn.esprit.espritgather.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.espritgather.entity.Recrutement;

public interface RecrutementRepository extends JpaRepository<Recrutement, Long> {
}
