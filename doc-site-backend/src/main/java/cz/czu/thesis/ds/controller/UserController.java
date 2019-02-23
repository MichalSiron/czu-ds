package cz.czu.thesis.ds.controller;

import cz.czu.thesis.ds.model.User;
import cz.czu.thesis.ds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

//
//    @GetMapping("/all")
//    public List<User> getAllUsers(){
//        List<User> users = new ArrayList<>();
//        users.add(new User(21L));
//
//        return users;
//    }

}
