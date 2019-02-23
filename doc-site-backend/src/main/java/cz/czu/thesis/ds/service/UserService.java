package cz.czu.thesis.ds.service;

import cz.czu.thesis.ds.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    /**
     * Fetches user information from the user endpoint
     *
     * @param id a not-null user id
     * @return Optional wrapping user information, or empty if information was not found
     */
    Optional<User> findUser(Long id);

    List<User> getDetails();

}
