package cz.czu.thesis.ds.dao;

import cz.czu.thesis.ds.base.BaseRepository;
import cz.czu.thesis.ds.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
