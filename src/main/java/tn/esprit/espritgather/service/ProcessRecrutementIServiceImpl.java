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

import java.util.HashMap;
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

        if (process.getNiveau() >= 0 && compareSkillsAndApprove(process,p))  {  // Use "vacancies" instead of "niveau"
            process.setNiveau(process.getNiveau() - 1);

            if (process.getNiveau() == 0) {
                recrutementRepository.delete(process); // Delete if vacancies reach zero
                // Optional: Log deletion or notify relevant parties
            } else {
                recrutementRepository.save(process);
            }
        }
}   public Long countApprovedProcesses() {
        return processRecrutementRepository.countByApproved(true);
    }

    public Long countNonApprovedProcesses() {
        return processRecrutementRepository.countByApproved(false);
    }


    public Map<Skill, Double> calculateSkillSelectionPercentageIncludingUnapproved() {
        List<ProcessRecrutement> allProcesses = processRecrutementRepository.findAll();
        Map<Skill, Integer> skillCounts = new HashMap<>();


        for (Skill skill : Skill.values()) {
            skillCounts.put(skill, 0);
        }


        for (ProcessRecrutement process : allProcesses) {
            Map<Skill, SkillLevel> processSkills = process.getSkills();
            if (processSkills != null) {
                for (Skill skill : processSkills.keySet()) {
                    skillCounts.put(skill, skillCounts.get(skill) + 1);
                }
            }
        }


        int totalProcesses = allProcesses.size();
        Map<Skill, Double> skillPercentages = new HashMap<>();
        for (Skill skill : skillCounts.keySet()) {
            double percentage = (double) skillCounts.get(skill) / totalProcesses * 100;
            skillPercentages.put(skill, percentage);
        }

        return skillPercentages;
    }


}



