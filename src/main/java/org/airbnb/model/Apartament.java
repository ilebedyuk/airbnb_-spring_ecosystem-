//package org.airbnb.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//
///**
// * @author ilebedyuk
// */
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//public class Apartament {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "apartamentId", nullable = false)
//    private Long apartamentId;
//    private String apartamentName;
//    private int price;
//    private String description;
//    @ManyToOne
//    private User owner;
//    @OneToMany
//    private List<ReservationDate> reservationDates;
//    @OneToMany
//    private List<Comment> comments;
//    @ManyToOne
//    private City city;
//    private String apartamentPhoto;
//}
