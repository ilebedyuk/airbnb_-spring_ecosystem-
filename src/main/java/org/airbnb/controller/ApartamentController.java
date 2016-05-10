package org.airbnb.controller;

import org.airbnb.domain.Apartament;
import org.airbnb.services.ApartamentService;
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
public class ApartamentController {

    @Inject
    ApartamentService apartamentService;

//    @RequestMapping(value = "/user/{name}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public AppUser create(@PathVariable String name) {
//        AppUser appUser = new AppUser();
//        appUser.setName(name);
//        return userRepository.save(appUser);
//    }

    @RequestMapping(value = "/apartament", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Apartament> findAll() {
        final List<Apartament> resultList = new ArrayList<>();
        final Iterable<Apartament> all = apartamentService.findAll();
        all.forEach(new Consumer<Apartament>() {
            @Override
            public void accept(Apartament apartament) {
                resultList.add(apartament);
            }
        });
        return resultList;
    }
}
