package com.garage.garage.repositories;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.garage.garage.models.Moto;

public interface MotoRepository extends ListCrudRepository<Moto, Long> {

    List<Moto> findByBrand(String brand);

    List<Moto> findByColor(String color);

    List<Moto> findByCategory(String category);

    List<Moto> findBySpeed(int speed);

}
