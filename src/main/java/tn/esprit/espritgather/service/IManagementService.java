package tn.esprit.espritgather.service;

import tn.esprit.espritgather.entity.Management;

import java.util.List;

public interface IManagementService {
    public List<Management> retrieveAllManagement();
    public Management retrieveManagement(Long idManagement);
    public Management addManagement(Management management);
    public void removeManagement(Long idManagement);
    public Management modifyManagement(Management management);
}
