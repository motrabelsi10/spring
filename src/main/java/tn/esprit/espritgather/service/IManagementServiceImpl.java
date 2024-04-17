package tn.esprit.espritgather.service;

import jakarta.persistence.EntityManager;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.espritgather.entity.Event;
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
    public List<Event> getOverlappingEvents(Management management) {
        Management m = retrieveManagement(management.getIdManagement());
        String sql = "SELECT * FROM `event` " +
                "WHERE " +
                "((DATE(event.date_start) = DATE(?1) OR DATE(event.date_finish) = DATE(?1) " +
                "OR DATE(?1) BETWEEN DATE(event.date_start) AND DATE(event.date_finish)) " +
                "OR " +
                "(DATE(event.date_start) = DATE(?2) OR DATE(event.date_finish) = DATE(?2) " +
                "OR DATE(?2) BETWEEN DATE(event.date_start) AND DATE(event.date_finish)));";


        return entityManager.createNativeQuery(sql)
                .setParameter(1, m.getEvent().getDateStart())
                .setParameter(2,m.getEvent().getDateFinish())
                .getResultList();


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

    @Override
    public Management AddClassroomsAcoordinally(Management m) {
        Management management = retrieveManagement(m.getIdManagement());
        management.setBloc(m.getBloc());
        management.setClasse(m.getClasse());
        String sql ="UPDATE `management` SET `bloc`='"+management.getBloc()+"',`classe`='"+management.getClasse()+"' WHERE `id_management`='"+management.getIdManagement()+"'  ";
        entityManager.createNativeQuery(sql).executeUpdate();
        return management;
    }
}
