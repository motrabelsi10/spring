package tn.esprit.espritgather.service;

import tn.esprit.espritgather.entity.ProcessRecrutement;
import tn.esprit.espritgather.entity.Publication;
import tn.esprit.espritgather.entity.Recrutement;
import tn.esprit.espritgather.repo.ProcessNotFoundException;

import java.util.List;

public interface IProcessRecrutementService {
    public List<ProcessRecrutement> retrieveAllProcesses();
    public ProcessRecrutement retrieveProcess(Long idProcessRecrutement);
    public ProcessRecrutement addProcess(ProcessRecrutement process);
    public void removeProcess(Long idProcessRecrutement);
    public ProcessRecrutement modifyProcess(ProcessRecrutement process);
    List<ProcessRecrutement> retrieveProcessesByRecrutement(Long idRecrutement);
    public boolean compareSkillsAndApprove(Recrutement recrutement, ProcessRecrutement process);
    public void approveProcess(Long idProcessRecrutement) throws ProcessNotFoundException;
    //void createProcessRecrutement(ProcessRecrutement processRecrutement);

    // Nouvelle méthode pour décrémenter le nombre de postes vacants
  //  void decrementVacancies(Long idRecrutement);
}

