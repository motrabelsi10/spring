package tn.esprit.espritgather.service;
import org.apache.velocity.exception.ResourceNotFoundException;
import tn.esprit.espritgather.entity.Recrutement;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.espritgather.entity.ProcessRecrutement;
import tn.esprit.espritgather.repo.ProcessRecrutementRepository;
import tn.esprit.espritgather.repo.RecrutementRepository;

import java.util.List;
@Service
@AllArgsConstructor

public class ProcessRecrutementIServiceImpl implements IProcessRecrutementService {
    ProcessRecrutementRepository processRecrutementRepository;

    public List<ProcessRecrutement> retrieveAllProcesses() { return processRecrutementRepository.findAll(); }
    public ProcessRecrutement retrieveProcess(Long idProcessRecrutement) {
        return processRecrutementRepository.findById(idProcessRecrutement).get();
    }
    public ProcessRecrutement addProcess(ProcessRecrutement process) {
        return processRecrutementRepository.save(process);
    }
    public void removeProcess(Long idProcessRecrutement) {
        processRecrutementRepository.deleteById(idProcessRecrutement);
    }
    public ProcessRecrutement modifyProcess(ProcessRecrutement process) {
        return processRecrutementRepository.save(process);
    }
    public List<ProcessRecrutement> retrieveProcessesByRecrutement(Long idRecrutement) {
        return processRecrutementRepository.findProcessRecrutementByRecrutement_IdRecrutement(idRecrutement); }


   /* @Override
    public void createProcessRecrutement(ProcessRecrutement processRecrutement) {
        processRecrutementRepository.save(processRecrutement);
        // Décrémenter le nombre de postes vacants associé au recrutement
        decrementVacancies(processRecrutement.getRecrutement().getIdRecrutement());
    }

   @Override
    public void decrementVacancies(Long idRecrutement) {
        Recrutement recrutement = recrutementRepository.findById(idRecrutement)
                .orElseThrow(() -> new ResourceNotFoundException("Recrutement"));
        int remainingVacancies = recrutement.getNiveau();
        if (remainingVacancies > 0) {
            recrutement.setNiveau(remainingVacancies - 1);
            recrutementRepository.save(recrutement);
        } else {
            throw new RuntimeException("there is no vaccanicies for this recrutement");
        }
    }*/

}
