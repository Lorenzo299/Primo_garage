package com.garage.garage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.garage.garage.models.Auto;
import com.garage.garage.models.Garage;
import com.garage.garage.models.Moto;
import com.garage.garage.repositories.GarageRepository;

@Service
public class GarageServiceImpl implements GarageService {

    @Autowired
    GarageRepository garageRepository;

    @Override
    public Garage create(Garage garage) {
        if (garage.getNameGarage() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return garageRepository.save(garage);
    }

    @Override
    public void delete(Long id) {

        if (garageRepository.existsById(id)) {
            Garage garage = garageRepository.findById(id).get();
            List<Auto> garageAutos = garage.getListaAuto();
            for (Auto auto : garageAutos) {
                auto.setGarage(null);
            }
            List<Moto> garageMotos = garage.getListaMoto();
            for (Moto moto : garageMotos) {
                moto.setGarage(null);
            }
            garageRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Garage not found");
        }
    }

    @Override
    public Garage read(Long id) {
        Optional<Garage> optGarage = garageRepository.findById(id);
        if (optGarage.isPresent()) {
            return optGarage.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Garage id= " + id + " not found");
        }

    }

    @Override
    public Garage read(String nameGarage) {

        if (nameGarage == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            return garageRepository.findByNameGarage(nameGarage);
        }
    }

    @Override
    public List<Garage> readAllGarage() {

        return garageRepository.findAll();
    }

    @Override
    public Garage update(Garage garage, Long id) {
        if (garageRepository.existsById(id)) {

            garage.setId(id);
            return garageRepository.save(garage);

        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }
    }

}
