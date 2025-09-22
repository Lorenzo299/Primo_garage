package com.garage.garage.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.garage.garage.Veicolo;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "motos")
public class Moto extends Veicolo {

    private int speed;

    @ManyToOne
    @JoinColumn(name = "garage_id")
    @JsonIgnoreProperties({ "listaMoto" })
    private Garage garage;

    public Moto(String brand, String color, String category, int speed, Garage garage) {
        super(brand, color, category);
        this.speed = speed;
        this.garage = garage;
    }

    public Moto() {
    };

    @Override
    public void enter() {
        System.out.println("La moto " + getBrand() + " entra nel garage");

    }

    @Override
    public void exit() {
        System.out.println("La moto " + getBrand() + " esce dal garage");

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

}
