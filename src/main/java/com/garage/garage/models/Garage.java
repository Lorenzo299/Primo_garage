package com.garage.garage.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "garage")
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_garage", nullable = false, unique = true)
    private String nameGarage;

    @OneToMany(mappedBy = "garage", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({ "garage" })
    private List<Moto> listaMoto = new ArrayList<Moto>();

    public List<Moto> getListaMoto() {
        return listaMoto;
    }

    public void setListaMoto(List<Moto> listaMoto) {
        this.listaMoto = listaMoto;
    }

    @OneToMany(mappedBy = "garage", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({ "garage" })
    private List<Auto> listaAuto = new ArrayList<Auto>();

    public List<Auto> getListaAuto() {
        return listaAuto;
    }

    public void setListaAuto(List<Auto> listaAuto) {
        this.listaAuto = listaAuto;
    }

    public Garage(String nameGarage) {

        this.nameGarage = nameGarage;

    }

    // public void addAuto(Auto auto) {
    // listaAuto.add(auto);
    // auto.setGarage(this);
    // }

    // public void removeAuto(Auto auto) {
    // listaAuto.remove(auto);
    // auto.setGarage(null);
    // }

    // public void addMoto(Moto moto) {
    // listaMoto.add(moto);
    // moto.setGarage(this);
    // }

    // public void removeMoto(Moto moto) {
    // listaMoto.remove(moto);
    // moto.setGarage(null);
    // }

    public Garage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameGarage() {
        return nameGarage;
    }

    public void setNameGarage(String nameGarage) {
        this.nameGarage = nameGarage;
    }

}
