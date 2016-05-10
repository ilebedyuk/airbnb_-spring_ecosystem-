package org.airbnb.controller;

import org.airbnb.domain.AppUser;
import org.airbnb.services.UserService;
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
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Inject
    UserService userService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(){
        return "Hello there !";
    }

//    @RequestMapping(value = "/user/{name}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public AppUser create(@PathVariable String name) {
//        AppUser appUser = new AppUser();
//        appUser.setName(name);
//        return userRepository.save(appUser);
//    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AppUser> findAll() {
        final List<AppUser> resultList = new ArrayList<>();
        final Iterable<AppUser> all = userService.findAll();
        all.forEach(new Consumer<AppUser>() {
            @Override
            public void accept(AppUser appUser) {
                resultList.add(appUser);
            }
        });
        return resultList;
    }
}
