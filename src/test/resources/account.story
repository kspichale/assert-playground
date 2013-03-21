Scenario: Withdraw money in cash

Given is an account with credit 3000
When I withdraw 1000
Then ensure that credit is 2000 