package tn.esprit.espritgather.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.espritgather.dto.SignupRequest;
import tn.esprit.espritgather.entity.User;
import tn.esprit.espritgather.repo.UserRepository;
import tn.esprit.espritgather.utils.JWTUtil;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean createUser(SignupRequest signupRequest) {
        //Check if User exists

        User user = new User();
        //hedhi fi blasset el user.setmail(signurequest.getmail())
        BeanUtils.copyProperties(signupRequest,user);

        // hash the password before saving
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(hashPassword);
        User createdUser = userRepository.save(user);
        // UserRepository.save(user);


        return true;


    }
}