package com.anhembi.ironcar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cars")
@Entity(name = "Car")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Car {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String brand;
	private String model;
	private String year;
	
	public Car(@Valid DataRegistrationCar carData) {
		this.name = carData.name();
		this.brand = carData.brand();
		this.model = carData.model();
		this.year = carData.year();
	}

	public void updateCar(@Valid DataUpdateCar dataUpdateCar) {
		if (dataUpdateCar.name() != null) {
			this.name = dataUpdateCar.name();
		}
		
		if (dataUpdateCar.brand() != null) {
			this.brand = dataUpdateCar.brand();
		}
		
		if (dataUpdateCar.model() != null) {
			this.model = dataUpdateCar.model();
		}
		
		if (dataUpdateCar.year() != null) {
			this.year = dataUpdateCar.year();
		}
	}

}
