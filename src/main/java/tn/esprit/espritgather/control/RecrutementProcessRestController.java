package tn.esprit.espritgather.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.espritgather.entity.ProcessRecrutement;


import java.util.List;


import tn.esprit.espritgather.service.IProcessRecrutementService;

import java.util.List;

    @Tag(name = "Gestion Process")
@RestController
@AllArgsConstructor
@RequestMapping("/process")
@CrossOrigin(origins = "http://localhost:4200")

public class RecrutementProcessRestController {
    IProcessRecrutementService processService;
    // http://localhost:8089/espritgather/process/retrieve-all-processes
    @Operation(description = "récupérer toutes les process de la base de données")
    @GetMapping("/processes")
    public List<ProcessRecrutement> getprocesss() {
        List<ProcessRecrutement> listProcesses = processService.retrieveAllProcesses();
        return listProcesses;
    }
    // http://localhost:8089/espritgather/process/retrieve-process/8
    @GetMapping("/retrieve-process/{process-id}")
    public ProcessRecrutement retrieveprocess(@PathVariable("process-id") Long pId) {
        ProcessRecrutement process = processService.retrieveProcess(pId);
        return process;
    }
    // http://localhost:8089/espritgather/process/add-process
    @PostMapping("/processes")
    public ProcessRecrutement addprocess(@RequestBody ProcessRecrutement p) {
        ProcessRecrutement process = processService.addProcess(p);
        return process;
    }
    // http://localhost:8089/espritgather/process/remove-process/{process-id}
    @DeleteMapping("/remove-process/{process-id}")
    public void removeprocess(@PathVariable("process-id") Long processId) {
        processService.removeProcess(processId);
    }
    // http://localhost:8089/espritgather/process/modify-process
    @PutMapping("/modify-process")
    public ProcessRecrutement modifyprocess(@RequestBody ProcessRecrutement c) {
        ProcessRecrutement process = processService.modifyProcess(c);
        return process;
    }
}