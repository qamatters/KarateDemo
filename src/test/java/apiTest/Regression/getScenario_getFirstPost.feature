@Test123 @Smoke @Regression

Feature: Test blog get all post feature

  Background:

    Given url baseURL

  Scenario: Fetch first post and validate the userid
    Given path 'posts/1'
    When method GET
    Then status 200
    And print 'Response time for this API is:', responseTime
    And def response1 = response
    And print response1.userId
    And assert response1.userId == 1


