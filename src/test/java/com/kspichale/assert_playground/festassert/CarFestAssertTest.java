package com.kspichale.assert_playground.festassert;

import static com.kspichale.assert_playground.model.EngineType.REGULAR_GAS;
import static com.kspichale.assert_playground.festassert.CarFestAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.kspichale.assert_playground.model.Car;
import com.kspichale.assert_playground.model.extras.AirConditioning;
import com.kspichale.assert_playground.model.extras.SoundSystem;

public class CarFestAssertTest {

	private Car car;

	@Before
	public void setupBeforeTest() {
		this.car = new Car().withEngineType(REGULAR_GAS).withExtras(new AirConditioning(), new SoundSystem());
	}

	@Test
	public void hamcrestExample() {
		assertThat(car).hasExtras(new SoundSystem(), new AirConditioning()).hasMinimumExtraCount(2).hasEngineType(REGULAR_GAS);
	}

}
