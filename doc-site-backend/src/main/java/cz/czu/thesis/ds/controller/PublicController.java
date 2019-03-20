package cz.czu.thesis.ds.controller;

import cz.czu.thesis.ds.model.Doctor;
import cz.czu.thesis.ds.model.User;
import cz.czu.thesis.ds.service.DoctorService;
import cz.czu.thesis.ds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/public", produces = MediaType.APPLICATION_JSON_VALUE)
public class PublicController {

    private final DoctorService doctorService;
    private final UserService userService;

    @Autowired
    PublicController(DoctorService doctorService, UserService userService){
        this.doctorService = doctorService;
        this.userService = userService;
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getDoctorList(){
        System.out.println("getDoctorList");
        Optional<List<Doctor>> oDoctor = doctorService.getAll();
        return oDoctor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable Long id){
        System.out.println("getDoctor");
        Optional<Doctor> oDoctor = doctorService.findById(id);
        return oDoctor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getDoctors(){
        System.out.println("getDoctors");
        Optional<List<Doctor>> oDoctor = doctorService.getAll();

        return oDoctor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}
