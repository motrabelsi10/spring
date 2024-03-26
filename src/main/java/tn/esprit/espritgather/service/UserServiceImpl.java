package tn.esprit.espritgather.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.espritgather.entity.User;
import tn.esprit.espritgather.repo.UserRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
   UserRepository userRepository;

    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }
    public User retrieveUser(Long userId) {
        return userRepository.findById(userId).get();
    }
    public User addUser(User u) {
        return userRepository.save(u);
    }
    public void removeUser(Long userId) {
        userRepository.deleteById(userId);
    }
    public User modifyUser(User user) {
        return userRepository.save(user);
    }
}
