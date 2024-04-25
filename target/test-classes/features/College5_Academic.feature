Feature: Academic Modules

  Background: 
    Given Once user enter the homepage click the Academic menu.

  Scenario: Postive Sceanrio for Academic Module
    Given user click the add academic button.
    When Enter the valid credentials.
    Then Click the submit button.
    And Check values has been shows or not.

  Scenario: Without enter anything click submit icon
    Given user click the add academic button.
    Then Click the submit button.
    Then Check how it behave.

  Scenario: Negative Scenario - Valid From and Invalid To input
    Given user click the add academic button.
    When Enter the vaid input and enter invalid input
    Then Click the submit button.
    But If the data is present throw error.

  Scenario: Negative Scenario - Working days Fields
    Given user click the add academic button.
    When Enter the invalid data in "-21"
    Then Click the submit button.
    But If it allows throw error.

  Scenario: NegativeScenario1 - Working days Fields
    Given user click the add academic button.
    When Enter some invalid data in working fields.

  Scenario: Positive Scenario - Edit
    Given User click the edit icons
    When User change working date values
    Then User click the update icon
    And Check the data has been changed or not
    
    Scenario: Without enter anything click submit and add
    Given user click the add academic button.
    When Click the submit and add button.
    
    Scenario: View - Academic
    Given user click the view icon in aca year.
    Then check all the values present or not.
