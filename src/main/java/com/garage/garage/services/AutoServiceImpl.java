package com.garage.garage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.garage.garage.models.Auto;
import com.garage.garage.repositories.AutoRepository;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    AutoRepository autoRepository;

    @Override
    public Auto create(Auto auto) {
        if (auto.getBrand() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else
            return autoRepository.save(auto);
    }

    @Override
    public void delete(Long id) {

        if (autoRepository.existsById(id)) {
            autoRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auto not found");
        }
    }

    @Override
    public Auto read(Long id) {
        Optional<Auto> optAuto = autoRepository.findById(id);
        if (optAuto.isPresent()) {
            return optAuto.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auto id= " + id + " not found");
        }
    }

    @Override
    public List<Auto> readAll() {

        return autoRepository.findAll();
    }

    @Override
    public List<Auto> readByBrand(String brand) {
        if (brand == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return autoRepository.findByBrand(brand);
    }

    @Override
    public List<Auto> readByCategory(String category) {
        if (category == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return autoRepository.findByCategory(category);
    }

    @Override
    public List<Auto> readByColor(String color) {
        if (color == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }
        return autoRepository.findByColor(color);
    }

    @Override
    public List<Auto> readByNdoors(Integer ndoors) {
        if (ndoors == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }
        return autoRepository.findByNdoors(ndoors);
    }

    @Override
    public Auto update(Auto auto, Long id) {
        if (autoRepository.existsById(id)) {
            auto.setId(id);

            return autoRepository.save(auto);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }

    }

}
