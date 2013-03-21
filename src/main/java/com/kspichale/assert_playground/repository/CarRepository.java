package com.kspichale.assert_playground.repository;

import org.springframework.data.repository.CrudRepository;

import com.kspichale.assert_playground.model.Car;

public interface CarRepository extends CrudRepository<Car, Long> {

	Car findByVin(String vin);
}
