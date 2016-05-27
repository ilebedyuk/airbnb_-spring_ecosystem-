package org.airbnb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author ilebedyuk
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationDate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reservationDateId;
    private Date start;
    private Date  finish;
    @ManyToOne
    private Apartament apartament;
}
