package com.kspichale.assert_playground.jbehave;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.junit.JUnitStories;

public class AccountStories extends JUnitStories {

	public AccountStories() {
		super();
		this.configuredEmbedder().candidateSteps().add(new AccountSteps());
	}

	@Override
	protected List<String> storyPaths() {
		return Arrays.asList("account.story");
	}
}