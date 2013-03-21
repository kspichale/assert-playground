package com.kspichale.assert_playground.festassert;

import static com.kspichale.assert_playground.festassert.CarFestAssert.assertThat;
import static com.kspichale.assert_playground.model.EngineType.REGULAR_GAS;

import org.junit.Before;
import org.junit.Test;

import com.kspichale.assert_playground.model.Car;
import com.kspichale.assert_playground.model.Extra;

public class CarFestAssertTest {

	private Car car;

	@Before
	public void setupBeforeTest() {
		this.car = new Car().withEngineType(REGULAR_GAS).withExtras(Extra.SOUND_SYSTEM, Extra.AIRCONDITIONING);
	}

	@Test
	public void hamcrestExample() {
		assertThat(car).hasExtras(Extra.SOUND_SYSTEM, Extra.AIRCONDITIONING).hasMinimumExtraCount(2)
				.hasEngineType(REGULAR_GAS);
	}

}
