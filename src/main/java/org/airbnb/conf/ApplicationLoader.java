package org.airbnb.conf;

import org.airbnb.domain.*;
import org.airbnb.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author ilebedyuk
 */
@Component
public class ApplicationLoader implements ApplicationListener<ContextRefreshedEvent> {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApartamentRepository apartamentRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ReservationDateRepository reservationDateRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        User appUser = new User();
        appUser.setUserName("Petya");
//        appUser.setSurname("Momot");
//        appUser.setEmail("petya@gmail.com");
//        appUser.setPassword("123");
        userRepository.save(appUser);

        City city1 = new City();
        city1.setCityName(CityName.CHERNIVCHI);
        city1.setCityPhoto("123.jpg");
        cityRepository.save(city1);

        Apartament apartament1 = new Apartament();
        apartament1.setApartamentType(ApartamentType.ROOM);
        apartament1.setPrice(15);
        apartament1.setDescription("nice room");
        apartament1.setApartamentPhoto("123.jpg");
        apartament1.setOwner(appUser);
        apartament1.setCity(city1);
        apartamentRepository.save(apartament1);

        Comment comment1 = new Comment();
        comment1.setMessage("Hello World!");
        comment1.setUser(appUser);
        comment1.setApartament(apartament1);
        commentRepository.save(comment1);

        ReservationDate reservationDate1 = new ReservationDate();
        reservationDate1.setApartament(apartament1);
        try {
            reservationDate1.setStart(sdf.parse("22-01-2015 10:20:56"));
            reservationDate1.setFinish(sdf.parse("24-01-2015 10:20:56"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        reservationDateRepository.save(reservationDate1);

        User appUser2 = new User();
        appUser2.setUserName("Vasya");
//        appUser2.setSurname("Nosov");
//        appUser2.setEmail("vasya@mail.ru");
//        appUser2.setPassword("123");
        userRepository.save(appUser2);

        City city2 = new City();
        city2.setCityName(CityName.KHARKIV);
        city2.setCityPhoto("12345.jpg");
        cityRepository.save(city2);

        Apartament apartament2 = new Apartament();
        apartament2.setApartamentType(ApartamentType.APARTAMENT);
        apartament2.setPrice(20);
        apartament2.setDescription("nice apartament");
        apartament2.setApartamentPhoto("1234.jpg");
        apartament2.setOwner(appUser2);
        apartament2.setCity(city2);
        apartamentRepository.save(apartament2);

        Comment comment2 = new Comment();
        comment2.setMessage("Thank you!");
        comment2.setUser(appUser2);
        comment2.setApartament(apartament2);
        commentRepository.save(comment2);

        ReservationDate reservationDate2 = new ReservationDate();
        reservationDate2.setApartament(apartament2);
        try {
            reservationDate2.setStart(sdf.parse("20-01-2016 10:20:56"));
            reservationDate2.setFinish(sdf.parse("24-01-2016 10:20:56"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        reservationDateRepository.save(reservationDate2);
    }
}
