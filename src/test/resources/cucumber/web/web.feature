Feature: Spring-cucumber feature goto google

  Scenario: Visit google.co.uk 
    Given I visit google search page
    When I type cucumber as a search string
    Then see the results