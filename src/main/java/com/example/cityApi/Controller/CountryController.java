package com.example.cityApi.Controller;

import com.example.cityApi.Interfaces.ICountry;
import com.example.cityApi.Models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile[] files) throws Exception {
        String path = "C:\\Users\\hudeifa\\Documents\\react-apps\\new-app - me\\public\\uploads";
        for(MultipartFile file:files){
            Files.copy(file.getInputStream(), Paths.get(path+ File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        }
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
