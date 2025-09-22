package com.garage.garage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.garage.garage.models.Auto;
import com.garage.garage.models.Garage;
import com.garage.garage.repositories.GarageRepository;

@SpringBootApplication
public class GarageApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarageApplication.class, args);

		// Garage garageCasa = new Garage("Home Garage");

		// Auto fiat500 = new Auto("fiat500", "grigia", "citycar", 3, garageCasa);

		// System.out.println(garageCasa.getListaAuto());

	}

	// @Bean
	// CommandLineRunner runner(GarageRepository garageRepository) {
	// return args -> {
	// if (!garageRepository.existsById(1L)) {
	// Garage garageCasa = new Garage("Home Garage");
	// garageRepository.save(garageCasa);
	// System.out.println("Garage salvato nel DB");
	// } else {
	// System.out.println("Garage già esistente, nessuna operazione eseguita.");
	// }
	// };
	// }

	// @Bean
	// CommandLineRunner runner(GarageRepository garageRepository) {
	// return args -> {
	// String nomeGarage = "Home Garage";

	// Garage garageEsistente = garageRepository.findByNameGarage(nomeGarage);

	// if (garageEsistente == null) {
	// Garage garageCasa = new Garage(nomeGarage);
	// garageRepository.save(garageCasa);
	// System.out.println("Garage salvato nel DB");
	// } else {
	// System.out.println("Garage già esistente con nome: " + nomeGarage);
	// }
	// };
	// }

}
