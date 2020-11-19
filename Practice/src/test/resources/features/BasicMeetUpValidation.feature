Feature: Meet Up Validation

  Background:
  Given user navigates to Meet up application login page

  Scenario: Title Verification
    Then   verify that web title is "Meetup - We are what we do"

  Scenario: URL Verification
    Then verifies the urs is "https://www.meetup.com/"

