package tn.esprit.espritgather.service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.espritgather.entity.Equipement;
import tn.esprit.espritgather.repo.EquipementRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IEquipementServiceImpl implements IEquipementService{
    EntityManager entityManager;
    EquipementRepository equipementRepository;
    @Override
    public List<Equipement> retrieveAllEquipments() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement retrieveEquipement(long id) {
        return equipementRepository.findById(id).get();
    }

    @Override
    public Equipement addEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

  //  @Transactional
    @Override
    public void removeEquipement(long id) {
    equipementRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Equipement modifyEquipement(Equipement equipement) {
        String sql ="UPDATE `equipement` SET `equipement`='"+equipement.getEquipement()+"',`other`='"+equipement.getOther()+"',`price`='"+equipement.getPrice()+"',`typeequip`='"+equipement.getTypeequip()+"' WHERE `id_equipmenet`='"+equipement.getIdEquipmenet()+"'";
        entityManager.createNativeQuery(sql).executeUpdate();
        return equipement;
    }
}
