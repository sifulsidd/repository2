@orange
Feature: User able to login to OrangeHRM site
Scenario: User successfully logs in 
Given user go to Orange HRM page site
When user type the username 
And user type the password
Then user click on login button
And user verify the welcome screen