package cz.czu.thesis.ds.repository;

import cz.czu.thesis.ds.base.BaseRepository;
import cz.czu.thesis.ds.model.Role;
import cz.czu.thesis.ds.model.RoleName;

import java.util.Optional;

public interface RoleRepository extends BaseRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);

}
