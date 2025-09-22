package com.garage.garage.services;

import java.util.List;

import com.garage.garage.models.Garage;

public interface GarageService {

    Garage create(Garage garage);

    Garage read(Long id);

    Garage update(Garage garage, Long id);

    void delete(Long id);

    Garage read(String nameGarage);

    List<Garage> readAllGarage();

}
