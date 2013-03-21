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
import com.kspichale.assert_playground.model.Extra;

public class CarHamcrestMatcherTest {

	private Car car;

	@Before
	public void setupBeforeTest() {
		this.car = new Car().withEngineType(REGULAR_GAS).withExtras(Extra.AIRCONDITIONING, Extra.SOUND_SYSTEM);
	}

	@Test
	public void hamcrestExample() {
		assertThat(
				car,
				allOf(hasExtras(Extra.AIRCONDITIONING, Extra.SOUND_SYSTEM), hasMinimumExtrasCount(2),
						hasEngineType(REGULAR_GAS)));
	}
}
