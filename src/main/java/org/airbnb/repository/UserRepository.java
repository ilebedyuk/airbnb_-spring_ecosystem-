package org.airbnb.repository;

import org.airbnb.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ilebedyuk
 */
@Repository
public interface UserRepository extends CrudRepository<AppUser,Long> {
}
