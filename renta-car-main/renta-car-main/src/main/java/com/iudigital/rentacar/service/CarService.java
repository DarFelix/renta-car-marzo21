package com.iudigital.rentacar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.rentacar.data.CarRepository;
import com.iudigital.rentacar.domain.Car;


@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	public void createCar(Car car) {
		carRepository.save(car);
	}
	
	public List<Car> getCars() {
		List<Car> cars = (List<Car>) carRepository.findAll();
		return cars;
	}
	
	public Car getCarById(int idCar) {

		Car car = carRepository.findById(idCar).orElse(new Car());
		return car;

	}
	
	
	
	public void editCar(int idCar, Car car) {

		Car carUpdate = carRepository.findById(idCar).orElse(null);
		if (carUpdate != null) {
			carUpdate.setLicencePlate(car.getLicencePlate());
			carUpdate.setBrand(car.getBrand());
			carUpdate.setColor(car.getColor());
			carUpdate.setFuelType(car.getFuelType());
			carUpdate.setKilometres(car.getKilometres());
			carUpdate.setModel(car.getModel());
			carUpdate.setMotor(car.getMotor());
			carUpdate.setNumberDoors(car.getNumberDoors());
			carUpdate.setPhoto(car.getPhoto());
			carUpdate.setTransmission(car.getTransmission());
			carUpdate.setYear(car.getYear());
			
			carRepository.save(carUpdate);
		}

	}
	
	public void deleteCar(int idCar) {
			
			carRepository.deleteById(idCar);
		
	}
	
	
	
	////search by color//
	
	public List<Car> getCarByColor(String color) {

		List<Car> cars = carRepository.findByColor(color);
		return cars;

	}
	
	
	//1. search distinct ... by fuel_type and color
	
	public List<Car> getDistinctByFuelTypeAndColor(String fuelType, String color){
		
		List<Car> cars = carRepository.findDistinctByFuelTypeAndColor(fuelType, color);
		return cars;
		
	}
	
	 
}
