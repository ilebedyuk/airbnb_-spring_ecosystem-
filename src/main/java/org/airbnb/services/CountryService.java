package org.airbnb.services;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.airbnb.domain.Country;
import org.airbnb.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author ilebedyuk
 */
@Service
@NoArgsConstructor
@Data
@Transactional
public class CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void save(Country country) {
        countryRepository.save(country);
    }

    public void delete(Country country){
        countryRepository.delete(country);
    }

    public Country findOne(long countryId) {
        return countryRepository.findOne(countryId);
    }

    public Iterable<Country> findAll(){
        return countryRepository.findAll();
    }

    public Page<Country> findAll(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }
}
