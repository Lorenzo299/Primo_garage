package com.garage.garage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.garage.garage.models.Auto;
import com.garage.garage.models.Garage;
import com.garage.garage.models.Moto;
import com.garage.garage.repositories.AutoRepository;
import com.garage.garage.repositories.GarageRepository;
import com.garage.garage.repositories.MotoRepository;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class GarageApplicationTests {

	@Autowired
	GarageRepository garageRepository;

	@Autowired
	AutoRepository autoRepository;

	@Autowired
	MotoRepository motoRepository;

	// @BeforeEach
	// void load() {
	// Garage garageTest = new Garage();
	// garageTest.setNameGarage("Garage numero 1");
	// garageRepository.save(garageTest);

	// Auto autoTest = new Auto();
	// autoTest.setBrand("fiat");
	// autoTest.setCategory("citycar");
	// autoTest.setColor("blu");
	// autoRepository.save(autoTest);

	// Moto motoTest = new Moto();
	// motoTest.setBrand("ducati");
	// motoTest.setCategory("pista");
	// motoTest.setColor("verde");
	// motoRepository.save(motoTest);

	// }

	@Test
	void contextLoads() {
	}

	// @Test
	// void findByNameGarage() {
	// assertThat(garageRepository.findByNameGarage("Garage numero
	// 1")).extracting("nameGarage")
	// .containsOnly("Garage numero 1");
	// }

	@Test
	void findByCategory() {
		assertThat(autoRepository.findByCategory("citycar")).extracting("category").containsOnly("citycar");

	}

	@Test
	void findByColor() {
		assertThat(motoRepository.findByColor("verde")).extracting("color").containsOnly("verde");
	}

}
