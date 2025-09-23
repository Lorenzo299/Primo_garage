package com.garage.garage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.garage.garage.models.Moto;
import com.garage.garage.repositories.MotoRepository;

@Service
public class MotoServiceImpl implements MotoService {

    @Autowired
    MotoRepository motoRepository;

    @Override
    public Moto create(Moto moto) {
        if (moto.getBrand() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        } else {

            return motoRepository.save(moto);
        }
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        } else {
            motoRepository.deleteById(id);
        }

    }

    @Override
    public Moto read(Long id) {
        Optional<Moto> optMoto = motoRepository.findById(id);
        if (optMoto.isPresent()) {

            return optMoto.get();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }
    }

    @Override
    public List<Moto> readAllMoto() {

        return motoRepository.findAll();
    }

    @Override
    public List<Moto> readByBrand(String brand) {
        if (brand == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return motoRepository.findByBrand(brand);
    }

    @Override
    public List<Moto> readByCategory(String category) {
        if (category == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        } else {

            return motoRepository.findByCategory(category);
        }
    }

    @Override
    public List<Moto> readByColor(String color) {
        if (color == null) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            return motoRepository.findByColor(color);
        }

    }

    @Override
    public List<Moto> readBySpeed(Integer speed) {
        if (speed == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        } else {

            return motoRepository.findBySpeed(speed);
        }
    }

    @Override
    public Moto update(Moto moto, Long id) {
        if (motoRepository.existsById(id)) {
            moto.setId(id);

            return motoRepository.save(moto);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }
    }

}
