package tn.esprit.espritgather.service;

import tn.esprit.espritgather.entity.Equipement;

import java.util.List;

public interface IEquipementService {
    public List<Equipement> retrieveAllEquipments();
    public List<Equipement> retrieveEquipementByEvent(long id);
    public List<Equipement> retrieveEquipementByClub(long id);

    public float getPriceByEvent(long id);
    public float getPriceByClub(long id);
    public Equipement retrieveEquipement(long id);
    public Equipement addEquipement(Equipement equipement);
    public void removeEquipement (long id);
    public Equipement modifyEquipement(Equipement equipement);

    Equipement addEquipementAdmin(Equipement c);
}
