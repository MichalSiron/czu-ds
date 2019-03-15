package cz.czu.thesis.ds.service;

import cz.czu.thesis.ds.model.Doctor;
import cz.czu.thesis.ds.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Doctor> findById(@NotNull Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<List<Doctor>> getAll() {
        return Optional.of(repository.findAll()).filter(list -> list.size() != 0);
    }
}
