package com.example.cityApi.Interfaces;

import com.example.cityApi.Models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICity extends JpaRepository<City,Integer> {

}
