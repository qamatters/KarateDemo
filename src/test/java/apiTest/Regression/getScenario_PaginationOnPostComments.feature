@Test123 @Smoke @Regression

Feature: Test blog get first post feature

  Background:

    Given url baseURL

  Scenario: Fetch all comments on page 1 where postid is 2
    Given path 'posts/1/comments'
    When method GET
    Then status 200
    And print 'Response time for this API is:', responseTime
    And print response.length
    Then match each response[*].postId == 1
