@createEmployee @Regression

  Feature: Test Create Employee API

    Background:

      Given url mdaendpoint

    Scenario: Create New Employee

    Given path '/api/v1/create'
    And request {"name":"test","salary":"123","age":"23"}
    When method POST
    Then status 200
    And def response1 = response
    And print response1
    And match response1 contains  {"name":"test","salary":"123","age":"23"}
