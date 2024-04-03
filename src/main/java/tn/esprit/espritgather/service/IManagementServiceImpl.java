package tn.esprit.espritgather.service;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.espritgather.entity.Management;
import tn.esprit.espritgather.repo.ManagementRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class IManagementServiceImpl implements IManagementService {
    EntityManager entityManager;
    ManagementRepository managementRepository;
    @Override
    public List<Management> retrieveAllManagement() {
        return managementRepository.findAll();
    }

    @Override
    public Management retrieveManagement(Long idManagement) {
        return managementRepository.findById(idManagement).get();
    }

    @Override
    public Management addManagement(Management management) {
        management.setBloc(null);
        management.setClasse(null);
        management.setApprouvement(null);
        return managementRepository.save(management);
    }


    @Override
    public Management addManagementAdmin(Management management) {
        return managementRepository.save(management);
    }

    @Override
    public void removeManagement(Long idManagement) {
       /* String sql = "DELETE FROM `management` WHERE `management`.`id_management` = "+idManagement;
        entityManager.createNativeQuery(sql);*/
      managementRepository.deleteById(idManagement);
    }

    @Transactional
    @Override
    public Management modifyManagement(Management management) {
       // String sql ="UPDATE `management` SET `bloc`='"+management.getBloc()+"',`classe`='"+management.getClasse()+"' WHERE `id_management`='"+management.getIdManagement()+"'  ";
        //entityManager.createNativeQuery(sql).executeUpdate();
        managementRepository.save(management);
        return management;
    }
}
