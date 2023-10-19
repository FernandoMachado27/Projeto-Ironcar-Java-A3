package com.anhembi.ironcar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.anhembi.ironcar.model.Car;
import com.anhembi.ironcar.model.CarRepository;
import com.anhembi.ironcar.model.DataDetailsCar;
import com.anhembi.ironcar.model.DataRegistrationCar;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity register(@RequestBody @Valid DataRegistrationCar carData, UriComponentsBuilder uriBuilder) {
		var car = new Car(carData);
		repository.save(car);
		
		var uri = uriBuilder.path("/car/{id}").buildAndExpand(car.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DataDetailsCar(car));
	}

}
