@Regression

Feature: Test Bugs in Karate

  Scenario: Test UI Bug

    * def expected =
    """
    {
      "abc": "abc",
      "def": "def",
      "xyz": "#ignore"
    }
    """

    * def actual =
    """
    {
      "abc": "abc",
      "def": "def",
      "xyz": "#ignore"
    }
    """
    * print expected
    * print actual
    * match actual == expected