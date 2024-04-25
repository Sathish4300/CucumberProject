Feature: College - Student Module

  Background: 
    Given Once user enter the homepage click the Student menu.

  Scenario: Positive Scenario for Login Module
    Given User click the add student button
    When Enter the valid crendials like "Students - 001","Students001","123456789","students1@gmail.com","12/05/2024","1235678","13/04/2000","12345","30","dsfdvs","dgsgsgsdgbx","opjnp","7451100","dsssdsf".
    Then Click the submit button
    And Check the count has been increased or not in homepage.

  Scenario: Without enter anything check how its behave
    Given User click the add student button
    When Without enter any data in student page.
    Then Click the submit button.
    And Check how it behaves in student menu.

  Scenario: Enter the same credentials what we entered in previous cases
  	Given User click the add student button
    When Enter the valid crendials like "Students - 001","Students001","123456789","students1@gmail.com","12/05/2024","1235678","13/04/2000","12345","30","dsfdvs","dgsgsgsdgbx","opjnp","7451100","dsssdsf".
    Then Click the submit button in student page.
    And Check the Error message showing or not in student page.
    
    
   Scenario: Enter the different valid crendials but enter the previous credentials in admission id 
   Given User click the add student button
    When Enter the valid crendials like "Students - 002","Students002","123456789","students2@gmail.com","12/05/2024","12356781","13/04/2000","12345","30","dsfdvs","dgsgsgsdgbx","opjnp","7451100","dsssdsf".
    Then Click the submit button in student page.
    And Check error message showing or not like admission id already exists
    
    Scenario: Enter the value in mandatory fields
    Given User click the add student button
    When Enter the valid crendials like "Students - 003","Students003","123456789","students3@gmail.com","1235678","12345","30","dsfdvs","dgsgsgsdgbx","7451100","1234".
    Then Click the submit button in student page.
    And Check the value present in student page or not.
    
    Scenario: Enter a value in dob and check how it behaves
    Given User click the add student button
    When Enter the valid crendial like "Students - 004","Students004","123456789","students4@gmail.com","1235678","12345","30","dsfdvs","dgsgsgsdgbx","7451100","1234".
    Then Click the submit button in student page.
    And Check the values present in student page or not.
    
    Scenario: Clear the ID and check how it behaves
    Given User click the add student button
    When Enter the valid crendial like "Students - 005","Students005","123456789","students5@gmail.com","1235678","12345","30","dsfdvs","dgsgsgsdgbx","7451100","1234".
    And Clear the ID Values.
    Then Click the submit button in student page.
    
    
    Scenario: Negative Value in Student Fields
    
    Given User click the add student button
    When Enter the negative values in email,mobile no,pincode etc..
    
    Scenario: Postive Scenario - Search some char in course search box and check it contains this char in sec menu
    Given User search the some word in search box like "s" in student menu.
    Then Grab all the text and check all the word this char is present or not in student menu.
    
    Scenario: Negative Scenario - Search irrelevant char and check how its behave in course in sec
    Given User search irrelevant word like "q" in student mmenu.
    Then Error Text is showing or not in student.
    
    Scenario: Click the view icon and check
    Given User click the view icon.
    Then Check all the values present or not.
    
    Scenario: Edit Scenario - Student
    Given User click the edit icon in Student page.
    When Edit some values in Student fields.
    Then Check edited data showing or not in Student menu.
    
    Scenario: Delete some section
    Given User click the delete icon in student
    When User click yes option in student
    Then Check deleted data is showing or not in student menu.