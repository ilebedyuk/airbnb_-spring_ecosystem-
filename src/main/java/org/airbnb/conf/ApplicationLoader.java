package org.airbnb.conf;

import org.airbnb.domain.*;
import org.airbnb.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ilebedyuk
 */
@Component
public class ApplicationLoader implements ApplicationListener<ContextRefreshedEvent> {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CountryRepository countryRepository;

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

        City city2 = new City();
        city2.setCityName(CityName.KHARKIV);
        city2.setCityPhoto("1234.jpg");
        cityRepository.save(city2);

        Country country1 = new Country();
        country1.setCountyName(CountyName.UKRAINE);
        List<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        country1.setCities(cities);
        countryRepository.save(country1);


        Country country3 = new Country();
        country3.setCountyName(CountyName.CHINA);
        countryRepository.save(country3);

        Country country4 = new Country();
        country4.setCountyName(CountyName.GERMANY);
        countryRepository.save(country4);

        Country country5 = new Country();
        country5.setCountyName(CountyName.USA);
        countryRepository.save(country5);

        Country country6 = new Country();
        country6.setCountyName(CountyName.USA);
        countryRepository.save(country6);

        Country country7 = new Country();
        country7.setCountyName(CountyName.USA);
        countryRepository.save(country7);

        Country country8 = new Country();
        country8.setCountyName(CountyName.USA);
        countryRepository.save(country8);

        Country country9 = new Country();
        country9.setCountyName(CountyName.UKRAINE);
        countryRepository.save(country9);


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

        City city3 = new City();
        city3.setCityName(CityName.KHARKIV);
        city3.setCityPhoto("12345.jpg");
        cityRepository.save(city3);

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
