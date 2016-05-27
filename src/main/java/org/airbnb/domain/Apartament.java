package org.airbnb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author ilebedyuk
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Apartament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long apartamentId;
    @Enumerated(EnumType.STRING)
    private ApartamentType apartamentType;
    private int price;
    private String description;
    private String apartamentPhoto;

    @ManyToOne
    private User owner;

//    @OneToMany
//    private List<ReservationDate> reservationDates;
    @ManyToOne
    private City city;
}
