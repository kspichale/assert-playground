package com.kspichale.assert_playground;

import static ch.lambdaj.Lambda.closure;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.of;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.Lambda.var;
import static com.kspichale.assert_playground.model.EngineType.REGULAR_GAS;
import static org.hamcrest.Matchers.equalTo;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import ch.lambdaj.function.closure.Closure1;
import ch.lambdaj.function.matcher.LambdaJMatcher;

import com.kspichale.assert_playground.model.Car;
import com.kspichale.assert_playground.model.EngineType;
import com.kspichale.assert_playground.model.extras.AirConditioning;
import com.kspichale.assert_playground.model.extras.SoundSystem;

public class LambdajTest {

	private Collection<Car> cars;

	@Before
	public void setupBeforeTest() {
		this.cars = new HashSet<Car>();
		cars.add(new Car().withEngineType(REGULAR_GAS).withExtras(new AirConditioning(), new SoundSystem()));
	}

	public static LambdaJMatcher<Collection<Car>> hasEngineType(EngineType engineType) {
		return having(on(Car.class).getEngineType(), equalTo(engineType));
	}

	@Test
	public void closureExample() {
		LambdaJMatcher<Car> matcher = having(on(Car.class).getEngineType(), equalTo(REGULAR_GAS));
		Closure1<Car> assertItems = closure(Car.class);
		{
			of(matcher).matches(var(Car.class));
		}
		assertItems.each(this.cars);
	}

}
