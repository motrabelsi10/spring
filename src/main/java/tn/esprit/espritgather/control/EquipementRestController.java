package tn.esprit.espritgather.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.espritgather.entity.Equipement;
import tn.esprit.espritgather.service.IEquipementService;

import java.util.List;

@Tag(name = "Gestion equipement")
@RestController
@AllArgsConstructor
@RequestMapping("/equipement")
@CrossOrigin(origins = "http://localhost:4200")
public class EquipementRestController {

    IEquipementService equipementService;

    // http://localhost:8089/espritgather/equipement/equipements
    @Operation(description = "récupération de tout les equipements")
    @GetMapping("/equipements")
    public List<Equipement> getEquipements() {
        List <Equipement> equipements = equipementService.retrieveAllEquipments();
        return equipements ;
    }


    // http://localhost:8089/espritgather/equipement/retrieve-equipement/8
    @GetMapping("/retrieve-equipement/{equipement-id}")
    public Equipement retrieveEquipement(@PathVariable("equipement-id") Long chId) {
        return equipementService.retrieveEquipement(chId);
    }


    // http://localhost:8089/espritgather/equipement/add-equipement
    @PostMapping("/add-equipement")
    public Equipement addEquipement(@RequestBody Equipement c) {
        return equipementService.addEquipement(c);
    }



    // http://localhost:8089/espritgather/equipement/remove-equipement/{equipement-id}
    @DeleteMapping("/remove-equipement/{equipement-id}")
    public void removeEquipement(@PathVariable("equipement-id") Long chId) {
        equipementService.removeEquipement(chId);
    }





    // http://localhost:8089/espritgather/equipement/modify-equipement
    @PutMapping("/modify-equipement")
    public Equipement modifyEquipement(@RequestBody Equipement c) {
        return equipementService.modifyEquipement(c);
    }




}
