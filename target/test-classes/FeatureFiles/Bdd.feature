#noinspection GherkinBrokenTableInspection
Feature: test



  Scenario: Testing

    Given user enter username and password
      | username | password  |
      | santosh  | chavan$45 |
      |          |           |

  Scenario: BDD table
    Given Enter random numbers bddtes
      | number | <null> |


 Scenario Outline: BDD example
    Given Enter random number "<number>" bdd test
    Examples:
      | number |
      |        |