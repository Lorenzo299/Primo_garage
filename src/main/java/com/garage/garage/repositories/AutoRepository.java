package com.garage.garage.repositories;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.garage.garage.models.Auto;

public interface AutoRepository extends ListCrudRepository<Auto, Long> {

    List<Auto> findByBrand(String brand);

    List<Auto> findByColor(String color);

    List<Auto> findByCategory(String category);

    List<Auto> findByNdoors(int ndoors);
}
