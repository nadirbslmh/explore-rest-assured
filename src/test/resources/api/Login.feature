Feature: Login
  As a user
  I want to login
  So that I can manage users

  Scenario: As a user I can login with valid credentials
    Given I set API endpoint for login
    When I send login request with valid credentials
    Then I receive valid HTTP response code 200
    And I receive valid data for login