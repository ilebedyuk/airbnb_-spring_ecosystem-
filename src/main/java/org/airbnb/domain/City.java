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
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cityId;
    @Enumerated(EnumType.STRING)
    private CityName cityName;
    private String cityPhoto;
}
