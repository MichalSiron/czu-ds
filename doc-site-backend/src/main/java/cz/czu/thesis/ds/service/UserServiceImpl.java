package cz.czu.thesis.ds.service;

import cz.czu.thesis.ds.UsernameNotFoundException;
import cz.czu.thesis.ds.repository.UserRepository;
import cz.czu.thesis.ds.model.User;
import cz.czu.thesis.ds.security.CustomUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(@NotBlank @NotNull String username) {
        User user = repository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found with username or email : " + username));

        return CustomUserPrincipal.create(user);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = repository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return CustomUserPrincipal.create(user);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return repository.findByUsername(username);
    }

}
