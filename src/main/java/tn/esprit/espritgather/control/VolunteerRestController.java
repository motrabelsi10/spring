package tn.esprit.espritgather.control;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.espritgather.entity.Task;
import tn.esprit.espritgather.entity.Volunteer;
import tn.esprit.espritgather.service.IVolunteerService;

import java.util.List;

@Tag(name = "Gestion Volunteer")
@RestController
@AllArgsConstructor
@RequestMapping("/volunteer")
@CrossOrigin(origins = "http://localhost:4200")
public class VolunteerRestController {
    IVolunteerService volunteerService;
    // http://localhost:8089/espritgather/volunteer/retrieve-all-volunteers
    @Operation(description = "récupérer toutes les volunteer de la base de données")
    @GetMapping("/retrieve-all-volunteers")
    public List<Volunteer> getvolunteers() {
        List<Volunteer> listVolunteers = volunteerService.retrieveAllVolunteers();
        return listVolunteers;
    }
    // http://localhost:8089/espritgather/volunteer/retrieve-volunteer/8
    @GetMapping("/retrieve-volunteer/{volunteer-id}")
    public Volunteer retrievevolunteer(@PathVariable("volunteer-id") Long chId) {
        Volunteer volunteer = volunteerService.retrieveVolunteer(chId);
        return volunteer;
    }
    // http://localhost:8089/espritgather/volunteer/add-volunteer
    @PostMapping("/add-volunteer")
    public Volunteer addvolunteer(@RequestBody Volunteer c) {
        Volunteer volunteer = volunteerService.addVolunteer(c);
        return volunteer;
    }
    // http://localhost:8089/espritgather/volunteer/remove-volunteer/{volunteer-id}
    @DeleteMapping("/remove-volunteer/{volunteer-id}")
    public void removevolunteer(@PathVariable("volunteer-id") Long chId) {
        volunteerService.removeVolunteer(chId);
    }
    // http://localhost:8089/espritgather/volunteer/modify-volunteer
    @PutMapping("/modify-volunteer")
    public Volunteer modifyvolunteer(@RequestBody Volunteer c) {
        Volunteer volunteer = volunteerService.modifyVolunteer(c);
        return volunteer;
    }

}