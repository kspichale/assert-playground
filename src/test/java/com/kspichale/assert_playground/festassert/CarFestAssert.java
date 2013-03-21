package com.kspichale.assert_playground.festassert;

import org.fest.assertions.GenericAssert;

import com.kspichale.assert_playground.model.Car;
import com.kspichale.assert_playground.model.EngineType;

public class CarFestAssert extends GenericAssert<CarFestAssert, Car> {

	protected CarFestAssert(Car actual) {
		super(CarFestAssert.class, actual);
	}

	public static CarFestAssert assertThat(Car actual) {
		return new CarFestAssert(actual);
	}

	public CarFestAssert hasExtras(Object... extras) {
		org.fest.assertions.Assertions.assertThat(actual.getExtras()).containsOnly(extras);
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

	public CarFestAssert hasVin(String vin) {
		org.fest.assertions.Assertions.assertThat(actual.getVin()).isEqualTo(vin);
		return this;
	}

	public CarFestAssert hasSamePersistentFieldsAs(Car original) {
		return hasEngineType(original.getEngineType()).hasExtras(original.getExtras().toArray()).hasVin(
				original.getVin());
	}
}
