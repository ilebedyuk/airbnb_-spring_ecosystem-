package org.airbnb.repository;

import org.airbnb.domain.City;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ilebedyuk
 */
public interface CityRepository extends CrudRepository<City,Long> {
}
