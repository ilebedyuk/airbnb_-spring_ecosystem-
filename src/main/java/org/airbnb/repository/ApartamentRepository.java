package org.airbnb.repository;

import org.airbnb.domain.Apartament;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ilebedyuk
 */
public interface ApartamentRepository extends CrudRepository<Apartament,Long> {
}
