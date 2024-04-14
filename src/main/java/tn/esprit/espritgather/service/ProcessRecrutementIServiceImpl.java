package tn.esprit.espritgather.service;
import org.apache.velocity.exception.ResourceNotFoundException;
import tn.esprit.espritgather.entity.Recrutement;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.espritgather.entity.ProcessRecrutement;
import tn.esprit.espritgather.enumeration.Skill;
import tn.esprit.espritgather.enumeration.SkillLevel;
import tn.esprit.espritgather.repo.ProcessNotFoundException;
import tn.esprit.espritgather.repo.ProcessRecrutementRepository;
import tn.esprit.espritgather.repo.RecrutementRepository;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor

public class ProcessRecrutementIServiceImpl implements IProcessRecrutementService {
    ProcessRecrutementRepository processRecrutementRepository;
    RecrutementRepository recrutementRepository;
    public List<ProcessRecrutement> retrieveAllProcesses() {
        return processRecrutementRepository.findAll();
    }

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
        return processRecrutementRepository.findProcessRecrutementByRecrutement_IdRecrutement(idRecrutement);
    }

    @Override
    public boolean compareSkillsAndApprove(Recrutement recrutement, ProcessRecrutement process) {
        // Compare skills and set approval status
        Map<Skill, SkillLevel> recruitmentSkills = recrutement.getRequiredSkills();
        Map<Skill, SkillLevel> processSkills = process.getSkills(); // Assuming getSkills exists

        // Check if both have required skills
        if (recruitmentSkills == null || processSkills == null) {
            // Handle missing skills scenario (optional)
            return false;
        }

        // Iterate through each skill in recruitment
        for (Map.Entry<Skill, SkillLevel> entry : recruitmentSkills.entrySet()) {
            Skill skillName = entry.getKey();
            SkillLevel requiredLevel = entry.getValue();

            // Check if skill exists in process and level matches (or allows flexibility)
            if (!processSkills.containsKey(skillName) ||
                    !matchSkillLevel(requiredLevel, processSkills.get(skillName))) {
                // If skill doesn't exist in process or level doesn't match, return false
                process.setApproved(false); // Set approval status to false
                processRecrutementRepository.save(process); // Save the process with approval status
                return false;
            }
        }

        // All required skills matched
        process.setApproved(true); // Set approval status to true
        processRecrutementRepository.save(process); // Save the process with approval status
        return true;
    }

    private boolean matchSkillLevel(SkillLevel requiredLevel, SkillLevel actualLevel) {

        return requiredLevel == actualLevel;
    }

    public void approveProcess(Long processId) throws ProcessNotFoundException {
        ProcessRecrutement p = processRecrutementRepository.getReferenceById(processId);
        Recrutement process = recrutementRepository.findById(processId)
                .orElseThrow(() -> new ProcessNotFoundException("Process not found with ID: " + processId));

        if (process.getNiveau() >= 0 && p.getApproved()==false )  {  // Use "vacancies" instead of "niveau"
            process.setNiveau(process.getNiveau() - 1);

           if (process.getNiveau() == 0) {
                recrutementRepository.delete(process); // Delete if vacancies reach zero
                // Optional: Log deletion or notify relevant parties
            } else {
                recrutementRepository.save(process);
            }
        }
}
}
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


