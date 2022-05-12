package com.example.cityApi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Integer id;
    private String countryName;
    private String countryCode;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "country_id")
    private Set<City> cities;
}
