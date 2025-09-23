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

import com.garage.garage.models.Moto;
import com.garage.garage.services.MotoService;

@RestController
@RequestMapping("/motos")
public class MotoRestController {

    @Autowired
    MotoService motoService;

    @PostMapping
    public Moto createMoto(@RequestBody Moto moto) {
        return motoService.create(moto);
    }

    @DeleteMapping("{id}")
    public void deleteMoto(@PathVariable("id") Long id) {
        motoService.delete(id);
    }

    @GetMapping("{id}")
    public Moto getMoto(@PathVariable("id") Long id) {
        return motoService.read(id);
    }

    @GetMapping
    public List<Moto> getAllMoto() {
        return motoService.readAllMoto();
    }

    @GetMapping("/motoBrand/{brand}")
    public List<Moto> getMotoByBrand(@PathVariable("brand") String brand) {
        return motoService.readByBrand(brand);
    }

    @GetMapping("/motoColor/{color}")
    public List<Moto> getMotoByColor(@PathVariable("color") String color) {
        return motoService.readByColor(color);
    }

    @GetMapping("/motoCategory/{category}")
    public List<Moto> getMotoByCategory(@PathVariable("category") String category) {
        return motoService.readByCategory(category);
    }

    @GetMapping("/motoSpeed/{speed}")
    public List<Moto> getMotoBySpeed(@PathVariable Integer speed) {
        return motoService.readBySpeed(speed);
    }

    @PutMapping("{id}")
    public Moto updateMoto(@RequestBody Moto moto, @PathVariable("id") Long id) {
        return motoService.update(moto, id);
    }

}
