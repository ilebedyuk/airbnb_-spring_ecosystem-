//package org.airbnb.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
///**
// * @author ilebedyuk
// */
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//public class Comment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "commentId", nullable = false)
//    private Long commentId;
//    private String message;
//    @ManyToOne
//    private User user;
//}
