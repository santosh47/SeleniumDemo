Feature: Login functinality scenarios


  @sm
  Scenario: Verify whether the User is able to login with valid credentials
    Given I launch the application
    And   I naviage to Account Login page
    When I login to the application using Username "Ravi.kiran2@gmail.com" and Password "rkiran"
    Then I should see that the User is able to successfully login
    And User clicks on AddressBook
    And User enters the address details
      | FirstName  | santosh     |
      | LastName   | Chavan      |
      | Company    | Appzui      |
      | Addressone | Chavan@123  |
      | Adrresstwo | Chavan@1234 |
      | City       | Gadag       |
      | Postcode   | 582103      |
      | Country    | Albania     |
      | Region     | Aberdeen    |
      | Default    | Chavan      |

  Scenario: Verify whether the User is able to login with invalid credentials
    Given I launch the application
    And   I naviage to Account Login page
    When I login to the application using Username "Ravi.kiran2@gmail.com" and Password "rkiran"
    Then I should see that the User is able to successfully login
    And User clicks on AddressBook
    And User enters the address invalid details

      | FirstName  | santosh     |
      | LastName   | Chavan      |
      | Company    | Appzui      |
      | Addressone | Chavan@123  |
      | Adrresstwo | Chavan@1234 |
      | City       | Gadag       |
      | Postcode   | 582103      |
      | Country    | Albania     |
      | Region     | Aberdeen    |
      | Default    | Chavan      |


  Scenario: Verify whether the User is able to login with empty credentials
    Given I launch the application
    And   I naviage to Account Login page
    When I login to the application using Username "Ravi.kiran2@gmail.com" and Password "rkiran"
    Then I should see that the User is able to successfully login
    And User clicks on AddressBook
    And User enters the address empty details
   |FirstName|
    |       |