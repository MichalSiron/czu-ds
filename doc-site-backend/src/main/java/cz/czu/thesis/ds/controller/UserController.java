package cz.czu.thesis.ds.controller;

import cz.czu.thesis.ds.exception.ResourceNotFoundException;
import cz.czu.thesis.ds.model.Doctor;
import cz.czu.thesis.ds.model.PersonDoctorValidation;
import cz.czu.thesis.ds.model.User;
import cz.czu.thesis.ds.payload.DoctorResponse;
import cz.czu.thesis.ds.payload.UserIdentityAvailability;
import cz.czu.thesis.ds.payload.UserProfile;
import cz.czu.thesis.ds.payload.UserSummary;
import cz.czu.thesis.ds.repository.UserRepository;
import cz.czu.thesis.ds.security.CurrentUser;
import cz.czu.thesis.ds.security.CustomUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('PATIENT')")
    public UserSummary getCurrentUser(@CurrentUser CustomUserPrincipal currentUser) {
        System.out.println(currentUser);
        return new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
    }

    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        long validatedDoctors = user.getPerson().getValidations().stream().filter(PersonDoctorValidation::isValidated).count();
        long invalidatedDoctors = user.getPerson().getValidations().stream().filter(validation -> !validation.isValidated()).count();

        return new UserProfile(user.getId(), user.getUsername(), user.getPerson().getName(), user.getCreatedAt(), validatedDoctors, invalidatedDoctors);
    }

    @GetMapping("/users/{username}/doctors")
    public List<DoctorResponse> getDoctors(@PathVariable(value = "username") String username,
                                                  @CurrentUser CustomUserPrincipal currentUser,
                                                  @RequestParam(value = "valid") Boolean valid) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        Stream<PersonDoctorValidation> stream = user.getPerson()
                .getValidations()
                .stream();

        if (valid)
            return mapper(stream.filter(PersonDoctorValidation::isValidated)).collect(Collectors.toList());
        else {
            return mapper(stream.filter(validation -> !validation.isValidated())).collect(Collectors.toList());
        }
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username){
        return new UserIdentityAvailability(!userRepository.existsByUsername(username));
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email){
        System.out.println(email);
        return new UserIdentityAvailability(!userRepository.existsByEmail(email));
    }

    private Stream<DoctorResponse> mapper(Stream<PersonDoctorValidation> stream){
        return stream.map(validation -> {
            final Doctor doctor = validation.getDoctor();

            String personUsername = userRepository.getPersonUsername(doctor.getPerson().getId());
            return new DoctorResponse(
                    doctor.getId(),
                    personUsername,
                    doctor.getPerson().getName(),
                    doctor.getSurgery().getAddress(),
                    doctor.getCreatedAt());
        });
    }

}
