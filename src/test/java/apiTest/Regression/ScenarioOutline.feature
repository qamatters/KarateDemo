@createEmployee @Regression

Feature: Validate Scenario Outline

  Background:

    Given url mdaendpoint

  Scenario: Fetch all Employees

    Given path '/api/v1/employee/7202'
    When method GET
    Then status 200
    And print 'Response time for this API is:', responseTime

    * def timeDelay =
    """
   function(pause){ java.lang.Thread.sleep(pause) }
    """
    * def temp = timeDelay(4000)

    And print 'temp value is:', temp
    And def response1 = response

