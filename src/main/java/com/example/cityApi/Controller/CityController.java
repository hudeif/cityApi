package com.example.cityApi.Controller;

import com.example.cityApi.Interfaces.ICity;
import com.example.cityApi.Models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cities")
public class CityController {
    @Autowired
    ICity iCity;

    @GetMapping("/list")
    public List<City>getAllCity(){
        return iCity.findAll();
    }
    @PostMapping("/add")
    public City addCity(@RequestBody City city )
    {
      return  iCity.save(city);
    }
    @PutMapping("/update")
    public City updateCity(@RequestBody City city )
    {
        return  iCity.save(city);
    }
    @GetMapping("/delete/{id}")
    public void deleteCity(@PathVariable Integer id){
        iCity.deleteById(id);
    }




}
