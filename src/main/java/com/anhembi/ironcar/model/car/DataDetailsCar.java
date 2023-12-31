package com.anhembi.ironcar.model.car;

public record DataDetailsCar(Long id, String name, String brand, String model, String year, String plan, String plate) {

	public DataDetailsCar(Car car) {
		this(car.getId(), car.getName(), car.getBrand(), car.getModel(), car.getYear(), car.getPlan(), car.getPlate());
	}
}
