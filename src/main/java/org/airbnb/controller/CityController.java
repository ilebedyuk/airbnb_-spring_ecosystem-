package org.airbnb.controller;

import org.airbnb.domain.City;
import org.airbnb.services.CityService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author ilebedyuk
 */

@RestController
public class CityController {

    @Inject
    CityService cityService;

    @RequestMapping(value = "/city", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<City> findAll() {
        final List<City> resultList = new ArrayList<>();
        final Iterable<City> all = cityService.findAll();
        all.forEach(new Consumer<City>() {
            @Override
            public void accept(City city) {
                resultList.add(city);
            }
        });
        return resultList;
    }
}
