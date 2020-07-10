@Test1234 @Smoke

Feature: Test Retry

  Background:

    Given url baseURL
    * configure retry = { count: 5, interval: 5000 }

  Scenario: Fetch all Employees

    Given path 'posts'
   And retry until responseStatus == 500
    When method GET
    Then status 200
