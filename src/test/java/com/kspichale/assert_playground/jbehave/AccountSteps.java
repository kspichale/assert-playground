package com.kspichale.assert_playground.jbehave;

import static org.fest.assertions.Assertions.assertThat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

public class AccountSteps extends Steps {
	int x;

	@Given("is an account with credit $value")
	public void givenValueX(@Named("value") int value) {
		x = value;
	}

	@When("I withdraw $value")
	public void whenWithdrawValue(@Named("value") int value) {
		x = x - value;
	}

	@Then("ensure that credit is $value")
	public void thenCreditShouldBe(@Named("value") int value) {
		assertThat(value).isEqualTo(x);
	}
}
