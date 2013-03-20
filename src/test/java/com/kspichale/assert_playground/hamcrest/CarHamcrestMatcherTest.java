package com.kspichale.assert_playground.hamcrest;

import static com.kspichale.assert_playground.hamcrest.CarHamcrestMatcher.hasEngineType;
import static com.kspichale.assert_playground.hamcrest.CarHamcrestMatcher.hasExtras;
import static com.kspichale.assert_playground.hamcrest.CarHamcrestMatcher.hasMinimumExtrasCount;
import static com.kspichale.assert_playground.model.EngineType.REGULAR_GAS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AllOf.allOf;

import org.junit.Before;
import org.junit.Test;

import com.kspichale.assert_playground.model.Car;
import com.kspichale.assert_playground.model.extras.AirConditioning;
import com.kspichale.assert_playground.model.extras.SoundSystem;

public class CarHamcrestMatcherTest {

	private Car car;

	@Before
	public void setupBeforeTest() {
		this.car = new Car().withEngineType(REGULAR_GAS).withExtras(new AirConditioning(), new SoundSystem());
	}

	@Test
	public void hamcrestExample() {
		assertThat(
				car,
				allOf(hasExtras(new AirConditioning(), new SoundSystem()), hasMinimumExtrasCount(2),
						hasEngineType(REGULAR_GAS)));
	}
}
