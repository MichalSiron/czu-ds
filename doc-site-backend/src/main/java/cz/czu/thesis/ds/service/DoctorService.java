package cz.czu.thesis.ds.service;

import cz.czu.thesis.ds.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    Optional<Doctor> findById(Long id);

    Optional<List<Doctor>> getAll();

}
