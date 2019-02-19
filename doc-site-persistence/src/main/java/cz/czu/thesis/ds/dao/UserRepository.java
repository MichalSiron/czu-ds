package cz.czu.thesis.ds.dao;

import cz.czu.thesis.ds.base.BaseRepository;
import cz.czu.thesis.ds.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
}
