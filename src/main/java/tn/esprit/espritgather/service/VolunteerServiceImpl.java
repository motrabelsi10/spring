package tn.esprit.espritgather.service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.espritgather.entity.Volunteer;
import tn.esprit.espritgather.repo.VolunteerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class VolunteerServiceImpl implements IVolunteerService {
    VolunteerRepository volunteerRepository;
    public List<Volunteer> retrieveAllVolunteers() { return volunteerRepository.findAll(); }
    public Volunteer retrieveVolunteer(Long volunteerId) {
        return volunteerRepository.findById(volunteerId).get();
    }
    public Volunteer addVolunteer(Volunteer c) {
        return volunteerRepository.save(c);
    }
    public void removeVolunteer(Long volunteerId) {
        volunteerRepository.deleteById(volunteerId);
    }
    public Volunteer modifyVolunteer(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }
}