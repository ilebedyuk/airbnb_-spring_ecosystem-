package org.airbnb.controller;

import org.airbnb.domain.ReservationDate;
import org.airbnb.services.ReservationDateService;
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
public class ReservationDateController {

    @Inject
    ReservationDateService reservationDateService;

    @RequestMapping(value = "/reservations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationDate> findAll() {
        final List<ReservationDate> resultList = new ArrayList<>();
        final Iterable<ReservationDate> all = reservationDateService.findAll();
        all.forEach(new Consumer<ReservationDate>() {
            @Override
            public void accept(ReservationDate reservationDate) {
                resultList.add(reservationDate);
            }
        });
        return resultList;
    }
}
