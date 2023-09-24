@Register
Feature: Auth
  As a user
  I want to access user management
  So that I can manage users

  Scenario: As a user I have be able to register
    Given I set api endpoint for register
    When I send request for register
    Then I receive valid data for new user