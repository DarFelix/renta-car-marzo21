package com.iudigital.rentacar.controller.converter;

import org.springframework.stereotype.Component;

import com.iudigital.rentacar.controller.dto.CarDTO;
import com.iudigital.rentacar.domain.Car;

@Component
public class CarConverter {

	public Car convertCarDTOToCar(CarDTO carDTO) {
		
		Car car= new Car();
		
		car.setIdCar(carDTO.getIdCar());
		car.setBrand(carDTO.getBrand());
		car.setFuelType(carDTO.getFuelType());
		car.setColor(carDTO.getColor());
		car.setKilometres(carDTO.getKilometres());
		car.setLicencePlate(carDTO.getLicencePlate());
		car.setModel(carDTO.getModel());
		car.setNumberDoors(carDTO.getMotor());
		car.setMotor(carDTO.getMotor());
		car.setPhoto(carDTO.getPhoto());
		car.setTransmission(carDTO.getTransmission());
		car.setYear(carDTO.getYear());
		
		return car;
		
	}
	
	
	public CarDTO convertCarToCarDTO(Car car) {
		
		CarDTO carDTO = new CarDTO();
		
		carDTO.setIdCar(car.getIdCar());
		carDTO.setBrand(car.getBrand());
		carDTO.setFuelType(car.getFuelType());
		carDTO.setColor(car.getColor());
		carDTO.setKilometres(car.getKilometres());
		carDTO.setLicencePlate(car.getLicencePlate());
		carDTO.setModel(car.getModel());
		carDTO.setNumberDoors(car.getMotor());
		carDTO.setMotor(car.getMotor());
		carDTO.setPhoto(car.getPhoto());
		carDTO.setTransmission(car.getTransmission());
		carDTO.setYear(car.getYear());
		
		return carDTO;
		
		
		
	}
	
	
	
}
