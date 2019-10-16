@Test1234 @Smoke

Feature: Test Retry

  Background:

    Given url mdaendpoint
    * configure retry = { count: 5, interval: 5000 }

  Scenario: Fetch all Employees

    Given path '/api/v1/employees'
   And retry until responseStatus == 200
    When method GET
    Then status 200
