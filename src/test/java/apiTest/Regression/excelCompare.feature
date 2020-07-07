Feature: Excel Comparison feature with Karate

  Background:

    * def excelHelper = Java.type("apiTest.ExcelComparator")

  Scenario: Compare the excel
    And def validationType = "dataValidation"
    And def compareResult = excelHelper.compareExcel(validationType);
    And match compareResult == true