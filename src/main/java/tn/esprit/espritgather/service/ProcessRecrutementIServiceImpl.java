package tn.esprit.espritgather.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.espritgather.entity.ProcessRecrutement;
import tn.esprit.espritgather.repo.ProcessRecrutementRepository;

import java.util.List;
@Service
@AllArgsConstructor

public class ProcessRecrutementIServiceImpl implements IProcessRecrutementService {
    ProcessRecrutementRepository processRecrutementRepository;
    public List<ProcessRecrutement> retrieveAllProcesses() { return processRecrutementRepository.findAll(); }
    public ProcessRecrutement retrieveProcess(Long processId) {
        return processRecrutementRepository.findById(processId).get();
    }
    public ProcessRecrutement addProcess(ProcessRecrutement process) {
        return processRecrutementRepository.save(process);
    }
    public void removeProcess(Long processId) {
        processRecrutementRepository.deleteById(processId);
    }
    public ProcessRecrutement modifyProcess(ProcessRecrutement process) {
        return processRecrutementRepository.save(process);
    }
}
