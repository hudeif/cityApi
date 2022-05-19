package com.example.cityApi.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonIgnoreProperties(value = {"cities", "handler","hibernateLazyInitializer"}, allowSetters = true)
    private Country country;



}
