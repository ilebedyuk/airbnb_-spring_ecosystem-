package org.airbnb.repository;

import org.airbnb.domain.ReservationDate;
import org.springframework.data.repository.CrudRepository;

/**
 * @author ilebedyuk
 */
public interface ReservationDateRepository extends CrudRepository<ReservationDate,Long> {
}
