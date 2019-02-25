package cz.czu.thesis.ds.controller;

import cz.czu.thesis.ds.model.User;
import cz.czu.thesis.ds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;
    private RestTemplate restTemplate;

    @Autowired
    UserController(UserService userService, RestTemplate restTemplate){
        this.userService = userService;
        this.restTemplate = restTemplate;
    }

//    @GetMapping("/detail")
//    ResponseEntity<User> currentUserDetail(Principal principal) {
//        return userDetail(principal.getName());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails){
        Optional<User> oUser = userService.findUser(id);
        oUser.map(User::getRoles).ifPresent(System.out::println);

        return oUser.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/book/{isbn}")
    String lookupBookByIsbn(@PathVariable String isbn){
        ResponseEntity<String> exchange = restTemplate.exchange("https://googleapis.com/books/v1/volumes?q=isbn:" + isbn, HttpMethod.GET, null,
                String.class);

        return exchange.getBody();
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
