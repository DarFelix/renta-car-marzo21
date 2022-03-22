package com.iudigital.rentacar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.iudigital.rentacar.data.CarRepository;
import com.iudigital.rentacar.domain.Car;
import com.iudigital.rentacar.service.CarService;

public class CarUnitTest {

	@InjectMocks
	private CarService carService;
	
	@Mock
	private CarRepository carRepository;
	

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getCarsTest() {
		
		when(carRepository.findAll()).thenReturn(getCars());
		
		List<Car> cars = carService.getCars();
		
		assertEquals(cars.size(), 1);
		
	}
	
	@Test
	public void createCar() {
		
		Car car = new Car();
		car.setId(1);
		car.setLicencePlate("JNR423");
		car.setColor("Rojo");
		car.setModel("2021");
		car.setBrand("Renault");
		
		when(carRepository.save(car)).thenReturn(car);
		
		assertEquals(car.getId(), 1);
		
		assertEquals(car.getLicencePlate(), "JNR423");
		
	}
	
	private List<Car> getCars() {
		
		List<Car> cars = new ArrayList<>();
		
		Car car = new Car();
		car.setId(1);
		car.setLicencePlate("JNR423");
		car.setColor("Rojo");
		car.setModel("2021");
		car.setBrand("Renault");
		
		cars.add(car);
		
		return cars;
		
	}
 
}
