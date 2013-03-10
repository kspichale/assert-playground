package com.kspichale.assert_playground.hamcrest;
import static ch.lambdaj.Lambda.*;
import static org.junit.Assert.*;
import static java.util.Arrays.*;

import java.io.StringWriter;
import java.util.Collection;

import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ch.lambdaj.function.closure.Closure;

import com.kspichale.assert_playground.model.Car;
import com.kspichale.assert_playground.model.EngineType;

public class CarsHamcrestMatcher extends TypeSafeMatcher<Collection<Car>> {

	private Matcher<Car> matcher;

	public CarsHamcrestMatcher(Matcher<Car> matcher) {
		super();
		this.matcher = matcher;
	}

	@Factory
	public static <T> Matcher<Collection<Car>> hasEngineType(EngineType engineType) {
		Matcher<Car> matcher = new HasEngineType(engineType);
		return new CarsHamcrestMatcher(matcher);
	}

	@Override
	public void describeTo(Description desc) {
		this.matcher.describeTo(desc);
	}

	@Override
	protected boolean matchesSafely(Collection<Car> cars) {
		
		StringWriter sw = new StringWriter();
		Closure writer = closure(); { of(sw).write(var(String.class)); }
		assertEquals(1, writer.getFreeVarsNumber());
		writer.each(asList("first", "second", "third"));
		assertEquals("firstsecondthird", sw.toString());

		return this.matcher.matches(cars);
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
}
