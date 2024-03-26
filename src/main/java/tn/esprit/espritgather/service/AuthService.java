package tn.esprit.espritgather.service;

import tn.esprit.espritgather.dto.SignupRequest;

public interface AuthService {
    boolean createUser(SignupRequest signupRequest);
}
