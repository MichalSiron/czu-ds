package cz.czu.thesis.ds.service;

import cz.czu.thesis.ds.UsernameNotFoundException;
import cz.czu.thesis.ds.dao.UserRepository;
import cz.czu.thesis.ds.model.User;
import cz.czu.thesis.ds.security.MyUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> findUser(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(@NotBlank @NotNull String username) {
        Optional<User> user = repository.findByUsername(username);
        User fs = user.orElseThrow(() -> new UsernameNotFoundException(User.class, username));

        return new MyUserPrincipal(fs);
    }

    @Override
    public List<User> getDetails() {
        return this.repository.findAll();
    }

}
