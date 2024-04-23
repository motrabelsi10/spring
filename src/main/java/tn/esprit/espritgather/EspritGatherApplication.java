package tn.esprit.espritgather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.esprit.espritgather.control.EventRestController;

import java.io.File;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication


public class EspritGatherApplication {

    public static void main(String[] args) {

        new File(EventRestController.uploadDirectory).mkdir();
        SpringApplication.run(EspritGatherApplication.class, args);
    }

}
