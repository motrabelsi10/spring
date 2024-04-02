package tn.esprit.espritgather.service;

import tn.esprit.espritgather.entity.ProcessRecrutement;

import java.util.List;

public interface IProcessRecrutementService {
    public List<ProcessRecrutement> retrieveAllProcesses();
    public ProcessRecrutement retrieveProcess(Long idProcessRecrutement);
    public ProcessRecrutement addProcess(ProcessRecrutement process);
    public void removeProcess(Long idProcessRecrutement);
    public ProcessRecrutement modifyProcess(ProcessRecrutement process);
    List<ProcessRecrutement> retrieveProcessesByRecrutement(Long idRecrutement);
    //void createProcessRecrutement(ProcessRecrutement processRecrutement);

    // Nouvelle méthode pour décrémenter le nombre de postes vacants
  //  void decrementVacancies(Long idRecrutement);
}

