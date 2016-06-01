package org.airbnb.repository;

import org.airbnb.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ilebedyuk
 */
public interface CountryRepository extends JpaRepository<Country, Long> {}
