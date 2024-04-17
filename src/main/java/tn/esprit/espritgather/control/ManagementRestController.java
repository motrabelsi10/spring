package tn.esprit.espritgather.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.espritgather.entity.Event;
import tn.esprit.espritgather.entity.Feedback;
import tn.esprit.espritgather.entity.Management;
import tn.esprit.espritgather.service.IManagementService;

import java.util.List;

@Tag(name = "Gestion management")
@RestController
@AllArgsConstructor
@RequestMapping("/management")
@CrossOrigin(origins = "http://localhost:4200")
public class ManagementRestController {

IManagementService managementService;

    // http://localhost:8089/espritgather/management/managements
    @Operation(description = "récupération de tout les feedbacks")
    @GetMapping("/managements")
    public List<Management> getmanagements() {
        List <Management> managements = managementService.retrieveAllManagement();
        return managements ;
    }

    // http://localhost:8089/espritgather/management/overlappingEvents/8
    @GetMapping("/overlappingEvents/{management-id}")
    public List<Event> getmanagements(@PathVariable("management-id") long c) {
        Management m= new Management();
        m.setIdManagement(c);
        List <Event> managements = managementService.getOverlappingEvents(m);
        return managements ;
    }


    // http://localhost:8089/espritgather/management/retrieve-management/8
    @GetMapping("/retrieve-management/{management-id}")
    public Management retrievemanagement(@PathVariable("management-id") Long chId) {
        return managementService.retrieveManagement(chId);
    }


    // http://localhost:8089/espritgather/management/add-management
    @PostMapping("/add-management")
    public Management addManagement(@RequestBody Management c) {
        return managementService.addManagement(c);
    }



    // http://localhost:8089/espritgather/management/remove-management/{management-id}
    @DeleteMapping("/remove-management/{management-id}")
    public void removeManagement(@PathVariable("management-id") Long chId) {
        managementService.removeManagement(chId);
    }

    // http://localhost:8089/espritgather/management/add-management-admin
    @PutMapping("/add-management-admin")
    public Management addManagementAdmin(@RequestBody Management c) {
        return managementService.addManagementAdmin(c);
    }



    // http://localhost:8089/espritgather/management/modify-management
    @PutMapping("/modify-management")
    public Management modifyManagement(@RequestBody Management c) {
        return managementService.modifyManagement(c);
    }

}
