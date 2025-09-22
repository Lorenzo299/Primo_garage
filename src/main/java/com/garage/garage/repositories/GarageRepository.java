package com.garage.garage.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.garage.garage.models.Garage;

public interface GarageRepository extends ListCrudRepository<Garage, Long> {

    Garage findByNameGarage(String nameGarage);
}
