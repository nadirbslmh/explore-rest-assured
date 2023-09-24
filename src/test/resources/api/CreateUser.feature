Feature: Create User
  As a admin
  I want to create a new user
  So that the new user can be stored

  Background:
    Given I set authorization header for the request

  Scenario: As a admin I can create an user with valid inputs
    Given I set API endpoint for create an user
    When I send create user request with valid inputs
    Then I receive valid HTTP response code 201
    And I receive valid data for created user