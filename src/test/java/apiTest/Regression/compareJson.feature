@Test123 @Smoke @Regression

Feature: Compare 2 JSON with different orders

  Background:
    * def utils = Java.type("apiTest.util")

  Scenario: Compare 2 Jsons

    * string firstJson = read ("TestData/first.json")
    * string secondJSON = read ("TestData/second.json")
#     And match firstJson == secondJSON
     And utils.compareJsonsIrrespectiveOfOrder(firstJson,secondJSON)

