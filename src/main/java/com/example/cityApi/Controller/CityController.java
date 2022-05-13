package com.example.cityApi.Controller;

import com.example.cityApi.Interfaces.ICity;
import com.example.cityApi.Interfaces.ICountry;
import com.example.cityApi.Models.City;
import com.example.cityApi.Models.Country;
import com.example.cityApi.Pojos.CityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cities")
@CrossOrigin(maxAge = 3600)
public class CityController {
    @Autowired
    ICity iCity;

    @Autowired
    ICountry iCountry;

    @GetMapping("/list")
    public List<City>getAllCity(){
        return iCity.findAll();
    }
    @PostMapping("/add")
    public City addCity(@RequestBody CityRequest cityRequest)

    {
        Country country = iCountry.findById(cityRequest.country_id);

        City city = new City();

        city.setId(cityRequest.id);
        city.setCityName(cityRequest.cityName);
        city.setCountry(country);

      return  iCity.save(city);
    }

    @PutMapping("/update")
    public City updateCity(@RequestBody City city)
    {
        return  iCity.save(city);
    }
    @GetMapping("/delete/{id}")
    public void deleteCity(@PathVariable Integer id){
        iCity.deleteById(id);
    }




}
