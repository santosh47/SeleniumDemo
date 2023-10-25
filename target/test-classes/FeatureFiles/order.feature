Feature: End to end scenarios for placing orders

  @Orders @One
  Scenario: Verify whether user is able to place an order
    Given I launch the application
    And I naviage to Account Login page
    When I login to the application using Username "ravi.kiran1@gmail.com" and Password "rkiran"
    Then I should see that the User is able to successfully login
    When I add any product to Bag and checkout
    And I place an order
    Then I should see that the order is placed successfully