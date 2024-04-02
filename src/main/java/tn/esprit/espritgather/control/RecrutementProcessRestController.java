package tn.esprit.espritgather.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.espritgather.entity.ProcessRecrutement;
import tn.esprit.espritgather.entity.Recrutement;
import tn.esprit.espritgather.service.IRecrutementService;
import tn.esprit.espritgather.service.IProcessRecrutementService;

import java.util.List;


import tn.esprit.espritgather.entity.Recrutement;
import tn.esprit.espritgather.service.IProcessRecrutementService;

import java.util.List;

    @Tag(name = "Gestion Process")
@RestController
@AllArgsConstructor
@RequestMapping("/process")
@CrossOrigin(origins = "http://localhost:4200")

public class RecrutementProcessRestController {
    IProcessRecrutementService processService;
    IRecrutementService recrutementService;
    // http://localhost:8089/espritgather/process/retrieve-all-processes
    @Operation(description = "récupérer toutes les process de la base de données")
    @GetMapping("/retrieve-all-processes")
    public List<ProcessRecrutement> getProcesss() {
        List<ProcessRecrutement> listProcesses = processService.retrieveAllProcesses();
        return listProcesses;
    }
    // http://localhost:8089/espritgather/process/retrieve-process/retrieve-process/{process-id}
    @GetMapping("/retrieve-process/{process-id}")
    public ProcessRecrutement retrieveProcess(@PathVariable("process-id") Long pId) {
        ProcessRecrutement process = processService.retrieveProcess(pId);
        return process;
    }
    // http://localhost:8089/espritgather/process/add-process
    @PostMapping("/add-process")
    public ProcessRecrutement addProcess(@RequestBody ProcessRecrutement p) {
        ProcessRecrutement process = processService.addProcess(p);
        return process;
    }
    // http://localhost:8089/espritgather/process/remove-process/{process-id}
    @DeleteMapping("/remove-process/{process-id}")
    public void removeProcess(@PathVariable("process-id") Long processId) {
        processService.removeProcess(processId);
    }
    // http://localhost:8089/espritgather/process/modify-process
    @PutMapping("/modify-process")
    public ProcessRecrutement modifyProcess(@RequestBody ProcessRecrutement c) {
        ProcessRecrutement process = processService.modifyProcess(c);
        return process;
    }
    @GetMapping("/retrieve-processes-by-recrutement/{recrutement-id}")
        public List<ProcessRecrutement> retrieveProcessesByRecrutement(@PathVariable("recrutement-id") Long idRecrutement) {
            List<ProcessRecrutement> processes = processService.retrieveProcessesByRecrutement(idRecrutement);
            return processes;
        }

        @PostMapping("/add-process-by-recrutement/{recrutement-id}")
        public ProcessRecrutement addProcessByRecrutement(@RequestBody ProcessRecrutement process, @PathVariable("recrutement-id") Long idRecrutement) {
            Recrutement recrutement = recrutementService.retrieveRecrutement(idRecrutement);

            process.setRecrutement(recrutement); // Associer le recrutement au processus de recrutement

            ProcessRecrutement addedProcess = processService.addProcess(process);
            return addedProcess;
        }
}