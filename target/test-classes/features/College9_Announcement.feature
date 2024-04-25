Feature: College - Announcement Module

  Background: 
    Given User click the announcement button

  Scenario: Positive Scenario in Announcement Module
    Given User click the add announcement
    When User enter the all credentials
    Then Click the submit button in announcement
    And Check the data is present or not in announcement module
