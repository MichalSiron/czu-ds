package cz.czu.thesis.ds.controller;

import cz.czu.thesis.ds.model.Doctor;
import cz.czu.thesis.ds.payload.DoctorResponse;
import cz.czu.thesis.ds.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;


    @GetMapping("/doctors")
    public List<DoctorResponse> getUserProfile() {
        List<Doctor> all = doctorRepository.findAll();

        return all.stream().map(doctor -> new DoctorResponse(
                doctor.getId(),
                doctor.getPerson().getName(),
                doctor.getSurgery().getAddress())
        ).collect(Collectors.toList());
    }

}
