package cz.czu.thesis.ds.controller;

import cz.czu.thesis.ds.payload.UserSummary;
import cz.czu.thesis.ds.repository.UserRepository;
import cz.czu.thesis.ds.security.CurrentUser;
import cz.czu.thesis.ds.security.CustomUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('PATIENT')")
    public UserSummary getCurrentUser(@CurrentUser CustomUserPrincipal currentUser) {
        return new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
    }

}
