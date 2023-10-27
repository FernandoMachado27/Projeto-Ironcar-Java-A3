package com.anhembi.ironcar.model;

import jakarta.validation.constraints.NotNull;

public record DataUpdateCar(
		@NotNull
		Long id,
		String name,
		String brand,
		String model,
		String year) {

}
