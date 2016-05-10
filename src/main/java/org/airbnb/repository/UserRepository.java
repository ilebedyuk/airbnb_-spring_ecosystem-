package org.airbnb.repository;

import org.airbnb.domain.AppUser;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ilebedyuk
 */
public interface UserRepository extends CrudRepository<AppUser,Long> {
}
