Feature: Address Book

Scenario Outline: Add New Address
  Given User clicks on AddressBook
  And User enters the address details

  Examples:
    | FirstName  | santosh      |
    | LastName   | Chavan       |
    | Company    | Appzui       |
    | Addressone | Chavan @123  |
    | Adrresstwo | Chavan @1234 |
    | City       | Gadag        |
    | Postcode   | 582103       |
    | Country    | India        |
    | Region     | Nagavi       |
    | Default    | Chavan       |




