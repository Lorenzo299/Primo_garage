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

import com.garage.garage.models.Auto;
import com.garage.garage.services.AutoService;

@RestController
@RequestMapping("/autos")
public class AutoRestController {

    @Autowired
    AutoService autoService;

    @PostMapping
    public Auto createAuto(@RequestBody Auto auto) {
        return autoService.create(auto);
    }

    @DeleteMapping("{id}")
    public void deleteAuto(@PathVariable("id") Long id) {

        autoService.delete(id);
    }

    @GetMapping("{id}")
    public Auto getAuto(@PathVariable("id") Long id) {
        return autoService.read(id);
    }

    @GetMapping
    public List<Auto> getAllAuto() {
        return autoService.readAll();
    }

    @GetMapping("/autoBrand/{brand}")
    public List<Auto> getAutosByBrand(@PathVariable("brand") String brand) {
        return autoService.readByBrand(brand);
    }

    @GetMapping("/autoCategory/{category}")
    public List<Auto> getAutosByCategory(@PathVariable("category") String category) {
        return autoService.readByCategory(category);
    }

    @GetMapping("/autoColor/{color}")
    public List<Auto> getAutosByColor(@PathVariable("color") String color) {
        return autoService.readByColor(color);
    }

    @GetMapping("/autoNumDoors/{ndoors}")
    public List<Auto> getAutosByNdoors(@PathVariable("ndoors") Integer ndoors) {
        return autoService.readByNdoors(ndoors);
    }

    @PutMapping("{id}")
    public Auto updateAuto(@RequestBody Auto auto, @PathVariable("id") Long id) {
        return autoService.update(auto, id);
    }
}
