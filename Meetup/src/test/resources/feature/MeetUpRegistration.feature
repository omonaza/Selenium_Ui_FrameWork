Feature: Meetup registration

  Background:
    Given user navigates to Meet up application login page
    When user clicks on Join Meetup button

  Scenario: verification of quick registration and sign up options are present
    Then user is provided with <options>
      | Continue with Facebook |
      | Continue with Google   |
      | Continue with Apple    |
      | Or sign up with email  |


  Scenario: verify continue button is disabled
    And selects Sign up with email option
    Then verify continue button is disabled when no input was provided

  Scenario: verification of message to confirm email and the email in the message
    And selects Sign up with email option
    When user enters the following credentials
      | name   | email           | password |
      | Azamat | testerCheking@gmail.com | 1234567passwordAzamat  |

    And clicks continue
    Then verifies the message to confirm an email is displayed
    And verifies that the email in the message is correct