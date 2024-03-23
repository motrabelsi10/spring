package tn.esprit.espritgather.service;

import tn.esprit.espritgather.entity.ProcessRecrutement;

import java.util.List;

public interface IProcessRecrutementService {
    public List<ProcessRecrutement> retrieveAllProcesses();
    public ProcessRecrutement retrieveProcess(Long idProcessRecrutement);
    public ProcessRecrutement addProcess(ProcessRecrutement process);
    public void removeProcess(Long idProcessRecrutement);
    public ProcessRecrutement modifyProcess(ProcessRecrutement process);
}
