package com.iudigital.rentacar.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.rentacar.domain.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

	
	//select * from car where color = "rojo"
	public List<Car> findByColor(String color);
	
	
	//1. SELECT DISTINCT * WHERE fuel_type = 'Gasolina' and year = '2022';
	public List<Car> findDistinctByFuelTypeAndColor(String fuelType, String color);
	

	
	
}
