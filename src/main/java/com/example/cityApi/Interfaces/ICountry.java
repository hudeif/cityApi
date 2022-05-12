package com.example.cityApi.Interfaces;

import com.example.cityApi.Models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountry extends JpaRepository<Country,Integer> {

    Country findById(int id);
}
