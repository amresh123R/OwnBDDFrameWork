
Feature: Validate Facebook login functionality

  Background: Launching Facebook site
    Given I launch the Facebook website on "chrome" browser
    
	@Smoke
  Scenario: Validate login with valid username and invalid password
    When I enter "valid_user@gmail.com" as username
    And I enter "wrong_password" as password
    Then I should see the error message "Facebook"