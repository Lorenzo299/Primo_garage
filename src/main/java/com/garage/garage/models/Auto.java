package com.garage.garage.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.garage.garage.Veicolo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "autos")
public class Auto extends Veicolo {
    @Column(name = "n_doors")
    private int ndoors;

    @ManyToOne
    @JoinColumn(name = "garage_id")
    @JsonIgnoreProperties({ "listaAuto" })
    private Garage garage;

    public Auto(String brand, String color, String category, int ndoors, Garage garage) {
        super(brand, color, category);
        this.ndoors = ndoors;
        this.garage = garage;
    }

    public Auto() {
    };

    @Override
    public void enter() {
        System.out.println("L' auto " + getBrand() + " entra nel garage");

    }

    @Override
    public void exit() {
        System.out.println("L' auto " + getBrand() + " esce dal garage");

    }

    public int getNdoors() {
        return ndoors;
    }

    public void setNdoors(int ndoors) {
        this.ndoors = ndoors;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

}
