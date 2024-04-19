package tn.esprit.espritgather.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.espritgather.entity.ProcessRecrutement;

import java.util.List;

public interface ProcessRecrutementRepository extends JpaRepository<ProcessRecrutement, Long> {
    List<ProcessRecrutement> findProcessRecrutementByRecrutement_IdRecrutement(Long idRecrutement);

    Long countByApproved(boolean b);


    List<ProcessRecrutement> findAllByApprovedTrue();
}

