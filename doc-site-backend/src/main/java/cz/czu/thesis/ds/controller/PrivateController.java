package cz.czu.thesis.ds.controller;

import cz.czu.thesis.ds.model.User;
import cz.czu.thesis.ds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class PrivateController {

    private final UserService userService;

    @Autowired
    PrivateController(UserService userService, RestTemplate restTemplate){
        this.userService = userService;
    }

//    @GetMapping("/detail")
//    ResponseEntity<User> currentUserDetail(Principal principal) {
//        return userDetail(principal.getName());
//    }

    @GetMapping("/users/{username}")
//    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<User> getUser(@PathVariable String username, @AuthenticationPrincipal UserDetails userDetails){
        System.out.println("AuthenticationPrincipal: "+userDetails);
        Optional<User> oUser = userService.findUserByUsername(username);
        oUser.map(User::getRoles).ifPresent(System.out::println);

        return oUser.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}
