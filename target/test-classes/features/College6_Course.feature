Feature: Course Module

  Background: 
    Given Once user enter the homepage click the Course menu.

  Scenario: Without enter anything click submit button and check how it behave
    Given User click the addCourse icon.
    When Without enter any data
    Then Click the submit icon.
    And Check how it behaves in course menu.

  Scenario: Positive Scenario - Course Module
    Given User click the addCourse icon.
    When Enter the all credentials like "IT Dep","IT001","8","sbs","dsgggggggggg","jjdsbsnsjsskjbskj"
    Then Click the submit icon.
    And Check the data present in Course page.

  Scenario: Negative Sceanrio - Missing one mandatory fields.
    Given User click the addCourse icon.
    When Enter the all data like "IT Dep","8","sbs","dsgggggggggg","jjdsbsnsjsskjbskj" but don't enter courseID
    Then Click the submit icon.
    And Check how it behaves in course menu.

  Scenario: Negative Scenario - Enter the existing data
    Given User click the addCourse icon.
    When Enter the all credentials like "IT Dep","IT001","8","sbs","dsgggggggggg","jjdsbsnsjsskjbskj"
    Then Click the submit icon.
    And Error Message showing or not in course page.

  Scenario: Edit Scenario - Value present or not
    Given User click the edit icon in course page.
    When Check all values showing or not.

  Scenario: Edit Scenario
    Given User click the edit icon in course page.
    When Edit some values.
    Then Check edited data showing or not.

  Scenario: Postive Scenario - Search some char in course search box and check it contains this char
    Given User search the some word in search box like "m" in course.
    Then Grab all the text and check all the word this char is present or not in course menu.

  Scenario: Negative Scenario - Search irrelevant char and check how its behave in course
    Given User search irrelevant word like "a" in course.
    Then Error Text is showing or not in course.

  Scenario: Delete some course
    Given User click the delete icon in course
    When User click yes option in course
    Then Check deleted data is showing or not.
