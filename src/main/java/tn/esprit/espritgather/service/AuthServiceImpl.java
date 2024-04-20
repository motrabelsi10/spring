package tn.esprit.espritgather.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.espritgather.dto.SignupRequest;
import tn.esprit.espritgather.entity.User;
import tn.esprit.espritgather.repo.UserRepository;
import tn.esprit.espritgather.utils.JWTUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


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
    public boolean createUser(SignupRequest signupRequest)  {


        //Check if User exists

        User user = new User();
        //hedhi fi blasset el user.setmail(signurequest.getmail())
        BeanUtils.copyProperties(signupRequest,user);
        //


        // hash the password before saving
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(hashPassword);
        User createdUser = userRepository.save(user);
        // UserRepository.save(user);


        return true;


    }


   





}