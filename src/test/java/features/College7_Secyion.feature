Feature: College - Section Module

  Background: 
    Given Once user enter the homepage click the Section menu.

  Scenario: Without enter anything in section page and then click submit button
    Given User click the addSrction icon.
    When Without enter any data in section page.
    Then Click the submit icon.
    And Check how it behaves in section menu.

  Scenario: Positive Scenario for Secction Module
    Given User click the addSrction icon.
    When Enter the valid crendials like "Dummy Class","Dummy Class - 1"
    Then Click the submit icon.
    And Check the data present in section menu or not.

  Scenario: Negative Scenario for Section Module
    Given User click the addSrction icon.
    When Enter the valid crendials like "Dummy Class","Dummy Class - 1" and dont select one mandatory fields.
    Then Click the submit icon.
    And Check how it behaves in section menu.

  Scenario: Negative Scenario1 for section module - Enter all credentials previously what we entered
    Given User click the addSrction icon.
    When Enter the valid crendials like "Dummy Class","Dummy Class - 1"
    Then Click the submit icon.
    And Error Message showing or not in section menu.

  Scenario: Negative Sceanrio2 User can able to clear the ID data or not.
    Given User click the addSrction icon.
    When Enter the valid crendials like "Dummy Class2","Dummy Class - 2"
    And Clear the ID data in section menu.
    Then Click the submit icon.
    And Check it allow or not in section menu.

  Scenario: Negative Scenario3 - Enter a negativve value in Section ID Fields
    Given User click the addSrction icon.
    When Enter the  crendials like "Dummy Class2","-20"
    Then Click the submit icon.
    And Check the if the data is present throw bugs.

  Scenario: Postive Scenario - Search some char in course search box and check it contains this char in sec menu
    Given User search the some word in search box like "a" in section menu.
    Then Grab all the text and check all the word this char is present or not in section menu.

  Scenario: Negative Scenario - Search irrelevant char and check how its behave in course in sec
    Given User search irrelevant word like "k" in section mmenu.
    Then Error Text is showing or not in section.

  Scenario: Edit Scenario - Value present or not
    Given User click the edit icon in Section page.
    When Check all values showing or not in section.

  Scenario: Edit Scenario
    Given User click the edit icon in Section page.
    When Edit some values in section fields.
    Then Check edited data showing or not in section menu.

  Scenario: Delete some section
    Given User click the delete icon in section
    When User click yes option in section
    Then Check deleted data is showing or not in section menu.
	
	Scenario: Search Module
		Given 
    