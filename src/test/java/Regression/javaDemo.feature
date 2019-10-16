Feature: Call java demo

  Background:

    Given url mdaendpoint

  Scenario: Get number from text

    Given path '/api/v1/create'
    And request {"name":"dee","salary":"123","age":"23"}
    When method POST
    Then status 200
    And def response1 = response
    * string temp = responseBytes
    And print temp
    * def emailText = response.name
    * def otpCode = Java.type('com.myPersonal.karate.util').getNumberFromString(emailText)
    * print otpCode