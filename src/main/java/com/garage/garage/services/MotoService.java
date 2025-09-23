package com.garage.garage.services;

import java.util.List;

import com.garage.garage.models.Moto;

public interface MotoService {

    Moto create(Moto moto);

    Moto read(Long id);

    List<Moto> readAllMoto();

    Moto update(Moto moto, Long id);

    void delete(Long id);

    List<Moto> readByBrand(String brand);

    List<Moto> readByColor(String color);

    List<Moto> readByCategory(String category);

    List<Moto> readBySpeed(Integer speed);
}
