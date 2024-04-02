package tn.esprit.espritgather.service;

import tn.esprit.espritgather.entity.Volunteer;

import java.util.List;
public interface IVolunteerService {
    public List<Volunteer> retrieveAllVolunteers();
    public Volunteer retrieveVolunteer(Long idVolunteer);
    public Volunteer addVolunteer(Volunteer c);
    public void removeVolunteer(Long idVolunteer);
    public Volunteer modifyVolunteer(Volunteer volunteer);

}