package org.airbnb.model;

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
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid", nullable = false)
    private Long userId;
    @Column(name = "name", nullable = false)
    private String name;

    //    private String surname;
//    private String email;


//    private String password;
//    @OneToMany
//    private List<Apartament> apartaments;
//    @OneToMany
//    private List<Comment> comments;
}
