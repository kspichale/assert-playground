package com.kspichale.assert_playground.festassert;

import org.fest.assertions.GenericAssert;

import com.kspichale.assert_playground.model.Car;
import com.kspichale.assert_playground.model.EngineType;
import com.kspichale.assert_playground.model.extras.Extra;

public class CarFestAssert extends GenericAssert<CarFestAssert, Car> {

	protected CarFestAssert(Car actual) {
		super(CarFestAssert.class, actual);
	}

	public static CarFestAssert assertThat(Car actual) {
		return new CarFestAssert(actual);
	}

	public CarFestAssert hasExtras(Extra... extras) {
		org.fest.assertions.Assertions.assertThat(actual.getExtras()).contains((Object[]) extras);
		return this;
	}

	public CarFestAssert hasMinimumExtraCount(int i) {
		org.fest.assertions.Assertions.assertThat(actual.getExtras().size()).isGreaterThanOrEqualTo(i);
		return this;
	}

	public CarFestAssert hasEngineType(EngineType regularGas) {
		org.fest.assertions.Assertions.assertThat(actual.getEngineType()).isEqualTo(regularGas);
		return this;
	}
}
