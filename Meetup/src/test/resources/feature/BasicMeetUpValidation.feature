Feature: Meet Up Validation

  Background:
    Given user navigates to Meet up application login page

  Scenario: Title Verification
    Then   verify that web title is "Meetup - We are what we do"

  Scenario: URL Verification
    Then verifies the urs is "https://www.meetup.com/"

  Scenario: MeetUp Button Verification
    Then verifies the Join Meetup button is displayed

  Scenario: Log in Button Verification
    Then verifies the "Log in" button is displayed

  Scenario: Sign up Button Verification
    Then verifies the sign up button is displayed