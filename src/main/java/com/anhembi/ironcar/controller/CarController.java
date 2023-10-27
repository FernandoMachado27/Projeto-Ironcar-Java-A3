package com.anhembi.ironcar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.anhembi.ironcar.model.car.Car;
import com.anhembi.ironcar.model.car.CarRepository;
import com.anhembi.ironcar.model.car.DataDetailsCar;
import com.anhembi.ironcar.model.car.DataRegistrationCar;
import com.anhembi.ironcar.model.car.DataUpdateCar;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarRepository repository;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	@Transactional
	public ResponseEntity register(@RequestBody @Valid DataRegistrationCar carData, UriComponentsBuilder uriBuilder) {
		var car = new Car(carData);
		repository.save(car);
		
		var uri = uriBuilder.path("/car/{id}").buildAndExpand(car.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DataDetailsCar(car));
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public ResponseEntity<List<DataDetailsCar>> list(){
		var cars = repository.findAll().stream().map(DataDetailsCar::new).toList();
		
		return ResponseEntity.ok(cars);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping
	@Transactional
	public ResponseEntity update(@RequestBody @Valid DataUpdateCar dataUpdateCar) {
		var car = repository.getReferenceById(dataUpdateCar.id());
		car.updateCar(dataUpdateCar);
		
		return ResponseEntity.ok(new DataDetailsCar(car));
	}
	
}
