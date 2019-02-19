package cz.czu.thesis.ds.service;

import cz.czu.thesis.ds.dao.UserRepository;
import cz.czu.thesis.ds.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> getUser(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<User> getDetails() {
        return this.repository.findAll();
    }

}
