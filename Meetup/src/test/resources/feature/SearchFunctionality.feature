Feature: Search Functionality
Background:
  Given  user navigates to Meet up application login page
  When the user types "conference" in the search field
  And the user hits Search button
  Scenario: Verify search results - title
    And the user hits Search button
    Then verify all search results contain "conference" in the title

     #implement a scenario
  @search
  Scenario: Verify search results - date
    And the user selects tomorrow from a dates dropdown
    Then verify all search results contain tomorrows date in the date fields