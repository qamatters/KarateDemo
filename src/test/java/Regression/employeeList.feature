@Test123 @Smoke

Feature: Test Employee API

  Background:

    Given url endpoint

  Scenario: Fetch all Employees

    Given path '/api/v1/employees'
    When method GET
    Then status 200
    And def response1 = response
