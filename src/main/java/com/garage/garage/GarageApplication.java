package com.garage.garage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.garage.garage.models.Auto;
import com.garage.garage.models.Garage;
import com.garage.garage.repositories.AutoRepository;
import com.garage.garage.repositories.GarageRepository;

@SpringBootApplication
public class GarageApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarageApplication.class, args);

	}

}
