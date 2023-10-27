package com.anhembi.ironcar.model.car;

import jakarta.validation.constraints.NotNull;

public record DataUpdateCar(
		@NotNull
		Long id,
		String name,
		String brand,
		String model,
		String year) {

}
