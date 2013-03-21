package com.kspichale.assert_playground.hamcrest;

import static com.kspichale.assert_playground.model.EngineType.REGULAR_GAS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

import org.junit.Before;
import org.junit.Test;

import com.kspichale.assert_playground.model.Car;
import com.kspichale.assert_playground.model.Extra;

public class HamcrestTest {

	private Car car;

	@Before
	public void setupBeforeTest() {
		this.car = new Car().withEngineType(REGULAR_GAS).withExtras(Extra.AIRCONDITIONING, Extra.SOUND_SYSTEM);
	}

	@Test
	public void hamcrestExample() {
		assertThat(car.getEngineType(), equalTo(REGULAR_GAS));
		assertThat(car.getExtras(), hasItem(Extra.AIRCONDITIONING));
		assertThat(car.getExtras(), hasSize(2));
	}
}
