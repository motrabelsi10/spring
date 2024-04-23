package tn.esprit.espritgather.service;

import org.springframework.web.multipart.MultipartFile;
import tn.esprit.espritgather.dto.SignupRequest;

import java.io.IOException;

public interface AuthService {
    boolean createUser(SignupRequest signupRequest) ;


}
