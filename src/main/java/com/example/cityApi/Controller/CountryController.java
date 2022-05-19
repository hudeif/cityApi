package com.example.cityApi.Controller;

import com.example.cityApi.Interfaces.ICountry;
import com.example.cityApi.Models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("countries")
@CrossOrigin(maxAge = 3600)
public class CountryController {
    @Autowired
    ICountry iCountry;

    @GetMapping("/list")
    public List<Country> getAll(){
        return iCountry.findAll();
    }


    @GetMapping("/{id}")
    public Country getOne(@PathVariable Integer id){
        return iCountry.findById(id).get();
    }

    @PostMapping("/add")
    public Country add(@RequestBody Country country){
        return iCountry.save(country);
    }

    @PutMapping("/update")
    public Country update(@RequestBody Country country){
        return iCountry.save(country);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        iCountry.deleteById(id);
    }
}
