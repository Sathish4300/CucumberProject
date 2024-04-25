Feature: College - Exam

  Background: 
    Given Once user enter the homepage click the exam menu.

  Scenario: Positive Scenario for exam module
    Given Once user enter the admin page click addExam button.
    When Enter all credentials in exam module.
    Then Exam has been created or not.

  Scenario: Without enter anything click submit button in exam
    Given Once user enter the admin page click addExam button.
    When Click the submit button in exam page.
    Then Check how it behave in exam page.

  Scenario: Without enter anything click submit and add button in exam
    Given Once user enter the admin page click addExam button.
    When Click the submit and add button in exam page.
    Then Check how it behave in exam page whether it shows error message or not.

  Scenario: Positive Scenario - Exam Link
    Given Once user enter the admin page click addExam button.
    When Enter all credentials in exam module and select link type.
    Then Check Exam has been created or not.

  Scenario: Positive Scenario - File Upload
    Given Once user enter the admin page click addExam button.
    When Enter all credentials in exam module and select file upload.
    Then Check Exam has been created or not.

  Scenario: Negative Scenario - Exam Module
    Given Once user enter the admin page click addExam button.
    When Enter all credentials in exam modules
    Then Throw Errors.

  Scenario: Negative Scenario1 - Exam Module
    Given Once user enter the admin page click addExam button.
    When Enter all credentials in exam modules except exam type
    Then Click submit and add icon and check how it behave.

  Scenario: Exisiting data entered and then click submit
    Given Once user enter the admin page click addExam button.
    When Enter all credentials in exam module and select link type.
    Then Error Message showing or not in exam page.

  Scenario: Enter mantatory fields only in exam
    Given Once user enter the admin page click addExam button.
    When Enter the mandatory fields in exam module.
    Then Check its created or not in exam page.

  Scenario: Negative Scenario in mark fields.
    Given Once user enter the admin page click addExam button.
    When Enter the validation and in total mark entered "50" and pass mark is "51".
    Then Check the error message shows or not related to mark.

  Scenario: Negative Scenario1 in mark fields.
    Given Once user enter the admin page click addExam button.
    When Enter the validation and in total mark entered "-50" and pass mark is "-51".
    Then Check the error message shows or not related to mark in exam module.

  Scenario: Irrelevant answer in answer fields and check how its behave
    Given Once user enter the admin page click addExam button.
    When Enter the values and enter irrelevant answer in answer field
    But If its allow its bug.
    
	Scenario: Postive Scenario - Search some char in exam search box and check it contains this char in sec menu
    Given User search the some word in search box like "um" in exam menu.
    Then Grab all the text and check all the word this char is present or not in exam menu.
    
   Scenario: Negative Scenario Search irrelevant char and check how it behave
    Given Search some word like "q" in exam.
    When Error message need to shows in exam.
    
    Scenario: Delete the branch in exam module
   
   Given Click the delete icon in exam
   Then Click the  Yes option in exam