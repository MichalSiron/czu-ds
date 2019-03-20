package cz.czu.thesis.ds.repository;

import cz.czu.thesis.ds.base.BaseRepository;
import cz.czu.thesis.ds.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    @Query("select username from User where person_id = :personId")
    String getPersonUsername(@Param("personId") Long personId);
}
