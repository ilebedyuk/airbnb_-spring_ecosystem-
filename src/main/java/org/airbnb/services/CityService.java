package org.airbnb.services;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.airbnb.domain.City;
import org.airbnb.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ilebedyuk
 */

@Service
@NoArgsConstructor
@Data
@Transactional
public class CityService {

    private CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void save(City city) {
        cityRepository.save(city);
    }

    public void delete(City city){
        cityRepository.delete(city);
    }

    public City findOne(long cityId) {
        return cityRepository.findOne(cityId);
    }

    public Iterable<City> findAll(){
        return cityRepository.findAll();
    }
}
