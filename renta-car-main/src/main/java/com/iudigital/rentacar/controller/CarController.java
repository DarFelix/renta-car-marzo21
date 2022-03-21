package com.iudigital.rentacar.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iudigital.rentacar.controller.converter.CarConverter;
import com.iudigital.rentacar.controller.dto.CarDTO;
import com.iudigital.rentacar.domain.Car;
import com.iudigital.rentacar.service.CarService;

@RestController
@RequestMapping("/car")
@CrossOrigin("*")
public class CarController {

	@Autowired
	private CarService carService;
	@Autowired
	private CarConverter carConverter;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createCar(@RequestBody CarDTO carDTO) {
		carService.createCar(carConverter.convertCarDTOToCar(carDTO));
	}
	
	@GetMapping
	public List<CarDTO> getCars() {
		return carService.getCars()
							.stream()
							.map(car -> carConverter.convertCarToCarDTO(car))
							.collect(Collectors.toList());
	
	}
	
	@GetMapping("/{IdCar}")
	public Car getCar(@PathVariable int IdCar) {
		return carService.getCarById(IdCar);
	}
	
	
	
	
	@PutMapping("/{IdCar}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void  editCar(@PathVariable int IdCar, @RequestBody Car car) {
		 carService.editCar(IdCar, car );
	}
	
	@DeleteMapping("/{IdCar}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCar(@PathVariable int IdCar) {
		 carService.deleteCar(IdCar);
	}
	
	
	//search by color
	@GetMapping("/color/{color}")
	public List<CarDTO> getCarByColor(@PathVariable String color) {
		return carService.getCarByColor(color)
							.stream()
							.map(car -> carConverter.convertCarToCarDTO(car))
							.collect(Collectors.toList());
	}
	
	//1. search distinct ... by fuel_type and color
	@GetMapping("distinct/fueltype/{fuelType}/color/{color}")
	public List<CarDTO> getDistinctByFuelTypeAndColor(@PathVariable String fuelType, @PathVariable String color){
		return carService.getDistinctByFuelTypeAndColor(fuelType, color)
							.stream()
							.map(car -> carConverter.convertCarToCarDTO(car))
							.collect(Collectors.toList());
	}
	
	
	
	
}
