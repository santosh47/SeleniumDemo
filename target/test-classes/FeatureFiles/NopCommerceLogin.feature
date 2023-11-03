Feature: NopCommerce Login

  @Register
  Scenario Outline: Register
    Given Navigate to Nopcommerce
    When User Registration
    And User enters personal details
      | Firstname    | Santosh       |
      | Lastname     | Chavan        |
      | Email        | nop@test.com  |
      | Confirmemail | nop@test.com  |
      | Username     | testing123242 |

    And User enters pssword confirmation

      | pssword         | Appzui |
      | confirmpassword | Appzui |

    And user enters  compny primary Account Details  "<My company primaril>" "<My main activity in the company is>" "<Does your company have an existing online store>"  "<What is your business model>" "<How many people work for your company>"" <My company’s website>"

    And User clicks on register button
    Examples:
      | My company primaril | My main activity in the company is | Does your company have an existing online store | What is your business model | What is your business model | How many people work for your company | My company’s website |
      | 1                   | 1                                  | 1                                               | 1                           | 1                           | 1                                     | 1                    |


  @Login
  Scenario Outline:  user Login
    Given    Navigate to Nopcommerce
    When user clicks on login button
    And user enters "<username>" and "<userpassword>"
    And user cliks on login button
    Examples:
      | username     | userpassword |
      | nop@test.com | testing      |

