package com.iudigital.rentacar;



import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iudigital.rentacar.domain.Car;
import com.iudigital.rentacar.service.CarService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarUnitTestInt {

	@Autowired
	private CarService carService;
	
	@Test
	public void createCar() {
		
		Car car = new Car();
		
		car.setColor("Rojo");
		car.setBrand("BMW");
		car.setModel("2022");
		car.setNumberDoors("4");
		car.setLicencePlate("777-888");
		
		carService.createCar(car);
		
		assertEquals(carService.getCars().size(), 1);
		
	}
	
}
