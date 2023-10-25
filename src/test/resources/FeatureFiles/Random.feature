Feature: test



  Scenario: Random Numbers
    Given Enter random numbers
      | number |
      | <number1> |

  Scenario Outline: random
    Given Enter random number "<number>"
    Examples:
      | number      |
      | <firstname> |