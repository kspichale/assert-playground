package com.kspichale.assert_playground.festassert;

import static com.kspichale.assert_playground.model.EngineType.REGULAR_GAS;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.kspichale.assert_playground.model.Car;
import com.kspichale.assert_playground.model.Extra;

public class FestAssertTest {

	private Car car;

	@Before
	public void setupBeforeTest() {
		this.car = new Car().withEngineType(REGULAR_GAS).withExtras(Extra.AIRCONDITIONING, Extra.SOUND_SYSTEM);
	}

	@Test
	public void hamcrestExample() {
		assertThat(car.getEngineType()).isEqualTo(REGULAR_GAS);
		assertThat(car.getExtras()).contains(Extra.AIRCONDITIONING).hasSize(2);
	}

}
