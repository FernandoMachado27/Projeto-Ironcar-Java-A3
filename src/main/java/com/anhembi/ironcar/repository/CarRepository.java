package com.anhembi.ironcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anhembi.ironcar.model.car.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

}
