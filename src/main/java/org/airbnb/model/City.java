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
//public class City {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "cityId", nullable = false)
//    private Long cityId;
//    private String cityName;
//    @OneToMany
//    private List<Apartament> apartaments;
//}
