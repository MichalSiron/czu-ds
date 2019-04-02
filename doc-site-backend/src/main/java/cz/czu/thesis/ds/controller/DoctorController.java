package cz.czu.thesis.ds.controller;

import cz.czu.thesis.ds.model.Doctor;
import cz.czu.thesis.ds.payload.DoctorResponse;
import cz.czu.thesis.ds.repository.DoctorRepository;
import cz.czu.thesis.ds.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DoctorController {

    private DoctorRepository doctorRepository;
    private UserRepository userRepository;

    @Autowired
    public DoctorController(DoctorRepository doctorRepository, UserRepository userRepository) {
        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/doctors")
    public List<DoctorResponse> getUserProfile() {
        List<Doctor> all = doctorRepository.findAll();

        return all.stream().map(doctor -> {
            String username = userRepository.getPersonUsername(doctor.getPerson().getId());

            return new DoctorResponse(
                    doctor.getId(),
                    username,
                    doctor.getPerson().getName(),
                    doctor.getSurgery().getAddress(),
                    doctor.getCreatedAt());

        }).collect(Collectors.toList());
    }

}
