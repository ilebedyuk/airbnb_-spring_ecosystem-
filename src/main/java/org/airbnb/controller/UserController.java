package org.airbnb.controller;

import org.airbnb.domain.User;
import org.airbnb.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<User> findAll() {
        final List<User> resultList = new ArrayList<>();
        final Iterable<User> all = userService.findAll();
        all.forEach(new Consumer<User>() {
            @Override
            public void accept(User appUser) {
                resultList.add(appUser);
            }
        });
        return resultList;
    }

    @RequestMapping(value = "/saveuser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public User save(@RequestBody User user) {
        userService.save(user);
        return user;
    }
}
