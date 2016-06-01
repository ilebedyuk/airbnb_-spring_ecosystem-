package org.airbnb.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author ilebedyuk
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long countryId;

    @Enumerated(EnumType.STRING)
    @JsonProperty("country")
    private CountyName countyName;

    @OneToMany
    @JsonProperty("cities")
    private List<City> cities;
}
