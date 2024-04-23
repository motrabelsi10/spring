package tn.esprit.espritgather.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.espritgather.dto.SignupRequest;
import tn.esprit.espritgather.enumeration.Role;
import tn.esprit.espritgather.service.AuthService;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/signup/club")
public class ClubSignUpController {
    private final AuthService authService ;
    //public static String uploadDirectory = "C:/Users/Admin/angular/src/assets/images/";
    public static String uploadDirectory = "C:/Users/ameni/OneDrive/Bureau/angular/src/assets/images/";

    public ClubSignUpController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<String> signupUser(SignupRequest signupRequest,@RequestParam("imageFile") MultipartFile imageFile) throws IOException {
        signupRequest.setRole(Role.club);

        boolean isUserCreated = authService.createUser(signupRequest,imageFile);
        if (isUserCreated) {


            return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\": \"User created successfully\"}");
        } else {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Failed to create user\"}");
        }

    }

}
