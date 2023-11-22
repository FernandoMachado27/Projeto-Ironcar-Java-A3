package com.anhembi.ironcar.model.car.validations;

import org.springframework.stereotype.Component;

import com.anhembi.ironcar.model.ValidationException;
import com.anhembi.ironcar.model.car.DataRegistrationCar;

@Component
public class ValidationYear implements ValidationRegisterCar{
	
	public void validate(DataRegistrationCar carData) {
		var yearString = carData.year();
		int year = Integer.parseInt(yearString);
		
		int yearLimit = 2000;
		
		if(year < yearLimit) {
			throw new ValidationException("Permitido cadastrar apenas carros fabricados a partir de 2000.");
		}
	}

}
