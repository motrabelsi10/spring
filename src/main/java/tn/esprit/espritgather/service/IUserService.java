package tn.esprit.espritgather.service;

import tn.esprit.espritgather.entity.User;

import java.util.List;

public interface IUserService {
    public List<User> retrieveAllUsers();
    public User retrieveUser(Long idUser);
    public User addUser(User u);
    public void removeUser(Long idUser);
    public User modifyUser(User user);
}
