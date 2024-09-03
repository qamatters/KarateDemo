@Test123 @Smoke @Regression @Single

Feature: Test blog get first post feature

  Background:

    Given url baseURL

  Scenario: Fetch all post for userid 1
    Given path 'posts'
    * param userId = 1
    When method GET
    Then status 200
    And print 'Response time for this API is:', responseTime
    And print response.length
    Then match each response[*].userId == 1

