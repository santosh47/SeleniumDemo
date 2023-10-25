Feature: Login functinality scenarios

@string
  Scenario: Verify whether the User is able to login with valid credentials
    Given I launch the application
    And I naviage to Account Login page
    When I login to the application using Username "Ravi.kiran2@gmail.com" and Password "rkiran"
    Then I should see that the User is able to successfully login

@table
  Scenario: Verify whether the User is able to login with invalid credentials
    Given I launch the application
    And I naviage to Account Login page
    When I login to the application using Username and Password
      | Validusername | Ravi                  |
      | LastName  | Kiran                 |
      | Email     | Ravi.kiran2@gmail.com |
      | Telephone | 9212345678            |
      | Password  | rkiran                |
   # Then I should see that the User is able to successfully login







