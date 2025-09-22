package com.garage.garage.services;

import java.util.List;

import com.garage.garage.models.Auto;

public interface AutoService {

    Auto create(Auto auto);

    Auto read(Long id);

    List<Auto> readAll();

    Auto update(Auto auto, Long id);

    void delete(Long id);

    List<Auto> readByBrand(String brand);

    List<Auto> readByColor(String color);

    List<Auto> readByCategory(String category);

    List<Auto> readByNdoors(Integer ndoors);

}
