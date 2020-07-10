@Test123 @Smoke @Regression

Feature: Test blog post feature

  Background:

    Given url baseURL

  Scenario: Update created post
    Given path 'posts/1'
    And request {title: 'test',body: 'bar',userId: 1}
    When method PUT
    Then status 200
    And print 'Response time for this API is:', responseTime
    And print response.id
    And assert response.id == 1
    And assert response.title == 'test'
    And assert response.body == 'bar'
    And assert response.userId == 1