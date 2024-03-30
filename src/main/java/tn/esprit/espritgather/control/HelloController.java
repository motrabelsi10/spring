package tn.esprit.espritgather.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.espritgather.dto.HelloResponse;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    public HelloResponse hello() {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

        return new HelloResponse("Hello from Authorized API request.");
    }
}
