@Test123 @Smoke @Regression

Feature: Test blog get first post feature

  Background:

    Given url baseURL

  Scenario: Fetch all post
    Given path 'posts'
    When method GET
    Then status 200 
    And print 'Response time for this API is:', responseTime
    And print response.length
    Then match each response[*].userId == '#number'
    Then match each response[*].id == '#number'
    Then match each response[*].title == '#string'
    Then match each response[*].body == '#string'
