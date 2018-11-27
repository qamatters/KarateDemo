Feature: a
  @dummy3
  Scenario: a
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
      "qwer" : "qwer"
    }
    """
    * print expected
    * print actual
    * match actual == expected