package com.kspichale.assert_playground;

import static com.kspichale.assert_playground.festassert.CarFestAssert.assertThat;
import static com.kspichale.assert_playground.model.EngineType.REGULAR_GAS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.kspichale.assert_playground.model.Car;
import com.kspichale.assert_playground.model.Extra;
import com.kspichale.assert_playground.repository.CarRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:repository-context.xml")
@Transactional
public class SingleAssertPerUnitTest {

	private Car car;

	@Autowired
	private CarRepository dao;

	@Before
	public void setupBeforeTest() {
		this.car = new Car().withEngineType(REGULAR_GAS)
				.withExtras(Extra.AIRCONDITIONING, Extra.SOUND_SYSTEM)
				.withVin("FOOBAR42");
	}

	// this test has multiple assertions
	@Test
	public void findCarByItsVin() {
		dao.save(car);
		assertNotNull(car.getId());
		Car foundCar = dao.findByVin(car.getVin());
		assertNotNull(foundCar);
		assertEquals(car, foundCar);
	}

	// better: has only one assertion
	@Test
	public void findCarByVin() {
		dao.save(car);
		Car foundCar = dao.findByVin(car.getVin());
		assertEquals(car, foundCar);
	}

	// better: this test has one assert statement with clear intention
	@Test
	public void canBePersisted() {
		dao.save(car);
		assertReloadsWithSamePersistentState(car);
	}

	private void assertReloadsWithSamePersistentState(Car original) {
		assertThat(dao.findOne(car.getId()))
				.hasSamePersistentFieldsAs(original);
	}

}
