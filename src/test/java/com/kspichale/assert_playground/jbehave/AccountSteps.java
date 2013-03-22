package com.kspichale.assert_playground.jbehave;

import static org.fest.assertions.Assertions.assertThat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

public class AccountSteps extends Steps {
	private Account account;

	@Given("is an account with credit $value")
	public void givenValueX(@Named("value") int value) {
		account = new Account(value);
	}

	@When("I withdraw $value")
	public void whenWithdrawValue(@Named("value") int value) {
		account.reduceCreditBy(value);
	}

	@Then("ensure that credit is $value")
	public void thenCreditShouldBe(@Named("value") int value) {
		assertThat(value).isEqualTo(account.getCredit());
	}
}
