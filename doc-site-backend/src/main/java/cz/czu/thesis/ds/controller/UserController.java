package cz.czu.thesis.ds.controller;

import cz.czu.thesis.ds.model.Person;
import cz.czu.thesis.ds.model.User;
import cz.czu.thesis.ds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

//    @GetMapping("/detail")
//    ResponseEntity<User> currentUserDetail(Principal principal) {
//        return userDetail(principal.getName());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        return userService.findUser(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    public void givenOptional_whenMapWorks_thenCorrect() {
        List<String> companyNames = Arrays.asList(
                "paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);

        Optional<Integer> integer = listOptional.map(List::size);

        int size = listOptional
                .map(List::size)
                .orElse(0);
    }

//
//    @GetMapping("/all")
//    public List<User> getAllUsers(){
//        List<User> users = new ArrayList<>();
//        users.add(new User(21L));
//
//        return users;
//    }

}
