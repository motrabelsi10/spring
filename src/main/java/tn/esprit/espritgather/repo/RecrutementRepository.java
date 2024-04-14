package tn.esprit.espritgather.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.espritgather.entity.Recrutement;

import java.util.List;

public interface RecrutementRepository extends JpaRepository<Recrutement, Long> {
    List<Recrutement> findByNiveauGreaterThan(int niveau);
}
