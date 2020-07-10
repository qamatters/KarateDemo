@Test123 @Smoke @Regression

Feature: Test blog post feature

  Background:

    Given url baseURL

  Scenario: Update created post
    Given path 'posts/1'
    When method DELETE
    Then status 200
    And print 'Response time for this API is:', responseTime