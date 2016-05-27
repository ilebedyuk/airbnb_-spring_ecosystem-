package org.airbnb.services;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.airbnb.domain.ReservationDate;
import org.airbnb.repository.ReservationDateRepository;
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
public class ReservationDateService {

    @Autowired
    ReservationDateRepository reservationDateRepository;

    public void save(ReservationDate reservationDate) {
        reservationDateRepository.save(reservationDate);
    }

    public void delete(ReservationDate reservationDate){
        reservationDateRepository.delete(reservationDate);
    }

    public ReservationDate findOne(long reservationDateId) {
        return reservationDateRepository.findOne(reservationDateId);
    }

    public Iterable<ReservationDate> findAll(){
        return reservationDateRepository.findAll();
    }
}
