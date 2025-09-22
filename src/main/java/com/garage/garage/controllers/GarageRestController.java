package com.garage.garage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garage.garage.models.Garage;
import com.garage.garage.services.GarageService;

@RestController
@RequestMapping("/garages")
public class GarageRestController {

    @Autowired
    GarageService garageService;

    @PostMapping
    public Garage createGarage(@RequestBody Garage garage) {
        return garageService.create(garage);
    }

    @DeleteMapping("{id}")
    public void deleteGarage(@PathVariable("id") Long id) {
        garageService.delete(id);
    }

    @GetMapping
    public List<Garage> getAllGarages() {
        return garageService.readAllGarage();
    }

    @GetMapping("{id}")
    public Garage getGarage(@PathVariable("id") Long id) {
        return garageService.read(id);
    }

    @GetMapping("/nameGarage/{nameGarage}")
    public Garage getGarageByName(@PathVariable("nameGarage") String name) {
        return garageService.read(name);
    }

    @PutMapping("{id}")
    public Garage updateGarage(@PathVariable("id") Long id, @RequestBody Garage garage) {
        return garageService.update(garage, id);
    }

}
