package com.kspichale.assert_playground.hamcrest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import com.kspichale.assert_playground.model.Car;
import com.kspichale.assert_playground.model.EngineType;
import com.kspichale.assert_playground.model.extras.Extra;

public class CarHamcrestMatcher extends TypeSafeMatcher<Car> {

	private Matcher<Car> matcher;

	public CarHamcrestMatcher(Matcher<Car> matcher) {
		super();
		this.matcher = matcher;
	}

	@Factory
	public static <T> Matcher<Car> hasExtras(Extra... extras) {
		Matcher<Car> matcher = new HasExtras(extras);
		return new CarHamcrestMatcher(matcher);
	}

	@Factory
	public static CarHamcrestMatcher hasMinimumExtrasCount(int i) {
		Matcher<Car> matcher = new HasMinimumExtraCount(i);
		return new CarHamcrestMatcher(matcher);
	}

	@Factory
	public static <T> Matcher<Car> hasEngineType(EngineType engineType) {
		Matcher<Car> matcher = new HasEngineType(engineType);
		return new CarHamcrestMatcher(matcher);
	}

	@Override
	public void describeTo(Description desc) {
		this.matcher.describeTo(desc);
	}

	@Override
	protected boolean matchesSafely(Car car) {
		return this.matcher.matches(car);
	}

	private static class HasEngineType extends CustomTypeSafeMatcher<Car> {

		private EngineType engineType;

		public HasEngineType(EngineType engineType) {
			super("engine type is " + engineType);
			this.engineType = engineType;
		}

		@Override
		protected boolean matchesSafely(Car car) {
			return car.getEngineType().equals(engineType);
		}
	}

	private static class HasMinimumExtraCount extends CustomTypeSafeMatcher<Car> {

		private int minimunExtraCount;

		public HasMinimumExtraCount(int minimunExtraCount) {
			super("has at least " + minimunExtraCount + " extras");
			this.minimunExtraCount = minimunExtraCount;
		}

		@Override
		protected boolean matchesSafely(Car car) {
			return car.getExtras().size() >= minimunExtraCount;
		}
	}

	private static class HasExtras extends CustomTypeSafeMatcher<Car> {

		private Extra[] extras;

		public HasExtras(Extra... extras) {
			super("has extras " + ToStringBuilder.reflectionToString(extras));
			this.extras = extras;
		}

		@Override
		protected boolean matchesSafely(Car car) {
			if (car.getExtras().size() != extras.length) {
				return false;
			}
			for (Extra extra : extras) {
				if (!car.getExtras().contains(extra)) {
					return false;
				}
			}
			return true;
		}
	}
}
