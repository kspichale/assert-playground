package com.kspichale.assert_playground.jbehave;

public class Account {

	private int credit;

	public Account(int credit) {
		this.credit = credit;
	}

	public void reduceCreditBy(int value) {
		this.credit -= value;
	}

	public Integer getCredit() {
		return credit;
	}

}
