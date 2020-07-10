@Test123 @Smoke @Regression

Feature: Test blog post feature

  Background:

    Given url baseURL

  Scenario: create a new post
    Given path 'posts'
    And request {title: 'foo',body: 'bar',userId: 1}
    When method POST
    Then status 201
    And print 'Response time for this API is:', responseTime
    And print response.id
    And assert response.id == 101
    And assert response.title == 'foo'
    And assert response.body == 'bar'
    And assert response.userId == 1