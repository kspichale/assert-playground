package com.kspichale.assert_playground;

import static com.kspichale.assert_playground.model.EngineType.REGULAR_GAS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.kspichale.assert_playground.dao.CarDao;
import com.kspichale.assert_playground.model.Car;
import com.kspichale.assert_playground.model.extras.AirConditioning;
import com.kspichale.assert_playground.model.extras.SoundSystem;

public class SingleAssertPerUnitTest {

	private Car car;

	private CarDao dao;

	@Before
	public void setupBeforeTest() {
		this.car = new Car().withEngineType(REGULAR_GAS).withExtras(new AirConditioning(), new SoundSystem());
		this.dao = new CarDao();
	}

	// this test has multiple assertions
	@Test
	public void findCarByItsVin() {
		dao.add(car);
		assertNotNull(car.getId());
		Car foundCar = dao.findByVin(car.getVin());
		assertNotNull(foundCar);
		assertEquals(car, foundCar);
	}

	// better: this test has one assert statement with clear intention
	@Test
	public void saveCar() {
		dao.add(car);
		assertReloadWithSamePersistentState(car);
	}

	// has only one assertion
	@Test
	public void findCarByVin() {
		dao.add(car);
		Car foundCar = dao.findByVin(car.getVin());
		assertSameCar(car, foundCar);
	}
	
	private void assertSameCar(Car expected, Car actual) {
		assertEquals(expected.getVin(), actual.getVin());
	}

	private void assertReloadWithSamePersistentState(Car car) {
		// TODO Auto-generated method stub
	}

}
