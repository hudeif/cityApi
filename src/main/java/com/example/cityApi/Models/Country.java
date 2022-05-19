package com.example.cityApi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @OneToMany
    @JoinColumn(name = "country_id")
    @JsonIgnoreProperties(value = {"country", "handler","hibernateLazyInitializer"}, allowSetters = true)
    private Set<City> cities;
}
