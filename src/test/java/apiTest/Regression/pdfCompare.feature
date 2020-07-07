Feature: PDF Comparison feature with Karate

  Background:

    * def pdfHelper = Java.type("apiTest.pdfComparator")

  Scenario: Compare the two identical PDF
    And def validationType = "dataValidation"
    And def compareResult = pdfHelper.comparePDF(validationType);
    And match compareResult == true