@Test123
Feature: Test create Employee API
  Scenario: Fetch all Employees
    Given url 'http://dummy.restapiexample.com/api/v1/create'
    And request {"name":"test","salary":"123","age":"23"}
    When method POST
    Then status 200
    And def response1 = response
    And print response1
    And match response1 contains  {"name":"test","salary":"123","age":"23"}
