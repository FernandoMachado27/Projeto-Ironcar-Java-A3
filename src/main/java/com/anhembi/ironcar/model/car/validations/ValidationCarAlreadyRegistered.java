package com.anhembi.ironcar.model.car.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anhembi.ironcar.model.ValidationException;
import com.anhembi.ironcar.model.car.DataRegistrationCar;
import com.anhembi.ironcar.repository.CarRepository;

@Component
public class ValidationCarAlreadyRegistered implements ValidationRegisterCar{
	
	@Autowired
	private CarRepository repository;

	@Override
	public void validate(DataRegistrationCar carData) {
		var plateExisting = repository.existsByPlate(carData.plate());
		
		if(plateExisting) {
			throw new ValidationException("Veículo com mesma placa já cadastrado");
		}
	}

}
