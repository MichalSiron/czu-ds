package cz.czu.thesis.ds.repository;

import cz.czu.thesis.ds.base.BaseRepository;
import cz.czu.thesis.ds.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends BaseRepository<Person, Long> {
}
