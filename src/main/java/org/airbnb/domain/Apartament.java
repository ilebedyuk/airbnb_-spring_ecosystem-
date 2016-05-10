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
    private String apartamentName;
    private int price;
    private String description;
    private String apartamentPhoto;

    @ManyToOne
    private AppUser owner;

//    @OneToMany
//    private List<ReservationDate> reservationDates;
//    @OneToMany
//    private List<Comment> comments;
//    @ManyToOne
//    private City city;
}
