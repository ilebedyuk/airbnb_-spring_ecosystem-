package org.airbnb.controller;

import org.airbnb.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * @author ilebedyuk
 */
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {

    @Inject
    UserRepository userRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(){
        return "Hello there !";
    }

//    @RequestMapping(value = "/user/{name}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public User create(@PathVariable String name) {
//        return userRepository.save(new User(name));
//    }

//    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<User> findAll() {
//        final List<User> resultList = new ArrayList<>();
//        final Iterable<User> all = userRepository.findAll();
//        all.forEach(new Consumer<User>() {
//            @Override
//            public void accept(User appUser) {
//                resultList.add(appUser);
//            }
//        });
//        return resultList;
//    }
}
