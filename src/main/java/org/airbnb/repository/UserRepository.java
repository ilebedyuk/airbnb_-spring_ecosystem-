package org.airbnb.repository;

import org.airbnb.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ilebedyuk
 */
public interface UserRepository extends CrudRepository<User,Long> {
}
