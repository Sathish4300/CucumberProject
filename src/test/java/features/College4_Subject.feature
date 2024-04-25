Feature: College - Subject Module

  Background: 
    Given Once user enter the homepage click the Subject menu.

  Scenario: Positive Scenario for subject module.
    Given User click the add subject icon
    When User enter the details like "Maths - 1","M1","Maths001".
    Then User click the submit icon.
    And Check the data present in subject page.

  Scenario: Negative Scenario1 for Branch Module
    Given User click the add subject icon
    When User enter the details like "Maths - 1","M1","Maths001".
    Then User click the Submit button.
    And Error Message showing or not in subject page.

  Scenario: Negative Scenario2 - Fac ID can able to clear the data or not.
    Given User click the add subject icon
    When User enter the details like "Maths - 2","M2","Maths002".
    Then User can able to clear facID or not.

  Scenario: Without enter anything and check how it behave.
    Given User click the add subject icon
    When Without enter anything click the submit button
    Then Check the fac urls how its behave

  Scenario: Edit some values and check how its behave
    Given User click the edit icon
    When Edit some values like "2"
    Then Click the update icon
    And Check Updated Value is presence or not.

  Scenario: Delete some faculty
    Given Click the deleted icon
    When Click the yes option
    Then verify deleted faculty is presence or not.

  Scenario: Search some valid Faculty
    Given Click the search option
    When Enter the valid faculty name
    Then Check the word contains in this fac name

  Scenario: Search some invalid Faculty
    Given Click the search option
    When Enter the invalid faculty name
    Then Error Text is showing or not in fac.
