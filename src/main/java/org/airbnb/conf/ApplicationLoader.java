package org.airbnb.conf;

import org.airbnb.domain.Apartament;
import org.airbnb.domain.AppUser;
import org.airbnb.repository.ApartamentRepository;
import org.airbnb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author ilebedyuk
 */
@Component
public class ApplicationLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApartamentRepository apartamentRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        AppUser appUser = new AppUser();
        appUser.setName("Petya");
        appUser.setSurname("Momot");
        appUser.setEmail("petya@gmail.com");
        appUser.setPassword("123");
        userRepository.save(appUser);

        Apartament apartament1 = new Apartament();
        apartament1.setApartamentName("room");
        apartament1.setPrice(15);
        apartament1.setDescription("nice room");
        apartament1.setApartamentPhoto("123.jpg");
        apartament1.setOwner(appUser);
        apartamentRepository.save(apartament1);


        AppUser appUser2 = new AppUser();
        appUser2.setName("Vasya");
        appUser2.setSurname("Nosov");
        appUser2.setEmail("vasya@mail.ru");
        appUser2.setPassword("123");
        userRepository.save(appUser2);

        Apartament apartament2 = new Apartament();
        apartament2.setApartamentName("apartament");
        apartament2.setPrice(20);
        apartament2.setDescription("nice apartament");
        apartament2.setApartamentPhoto("1234.jpg");
        apartament2.setOwner(appUser2);
        apartamentRepository.save(apartament2);
    }
}
