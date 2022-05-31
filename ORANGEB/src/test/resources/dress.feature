@dress
Feature: Verify total price including shipping
Scenario: User able to add second highest dress and see the total price
Given user goes to automationpractice site
When user clicks on the dress tab 
And user capture all dress prices from resultset
And user add to the cart the second highest price dress
Then user verify the total price including shipping