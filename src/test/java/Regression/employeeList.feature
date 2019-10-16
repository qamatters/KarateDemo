@Test123 @Smoke @Regression

Feature: Test Employee API

  Background:

    Given url mdaendpoint
    * def HashSet = Java.type('java.util.HashSet')
    * def nullFound = false
    * def fun = function(k, v){ if (!k) karate.set('nullFound', true) }

  Scenario: Fetch all Employees

    Given path '/api/v1/employee/7202'
    When method GET
    Then status 200
    And print 'Response time for this API is:', responseTime
    And def response1 = response
    * eval karate.forEach(response1, fun)
    * match nullFound == false


