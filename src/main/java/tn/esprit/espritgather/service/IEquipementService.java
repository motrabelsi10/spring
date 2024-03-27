package tn.esprit.espritgather.service;

import tn.esprit.espritgather.entity.Equipement;

import java.util.List;

public interface IEquipementService {
    public List<Equipement> retrieveAllEquipments();
    public Equipement retrieveEquipement(long id);
    public Equipement addEquipement(Equipement equipement);
    public void removeEquipement (long id);
    public Equipement modifyEquipement(Equipement equipement);

}
