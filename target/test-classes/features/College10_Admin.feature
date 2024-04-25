Feature: College - Admin Module

  Background: 
    Given Once user enter the homepage click the admin menu.

  Scenario: Positive Scenario - Admin Module
    Given Once user enter the admin page click addadmin button.
    When Enter the  all credials in admin.
    Then Check the data has been present or not in admin page.

  Scenario: Without enter anything click submit button in admin
    Given Once user enter the admin page click addadmin button.
    When Click the submit button in admin page.
    Then Check how it behave in admin page.

  Scenario: Without enter anything click submit and add button in admin
    Given Once user enter the admin page click addadmin button.
    When Click the submit and add button in admin page.
    Then Check how it behave in admin page whether it shows error message or not.

  Scenario: Without enter anything some data is present refresh the page
    Given Once user enter the admin page click addadmin button.
    Then Refresh the page and check.

  Scenario Outline: Positive Sceanrio - Admin - Click  Option
    Given Once user enter the admin page click addadmin button.
    When Enter the  all credials in admin like "<name>","<adminID>","<emailID>","<password>","<mobileNo>".
    Then Click the respective role in admin.

    Examples: 
      | name   | adminID  | emailID          | password | mobileNo |
      | Admin2 | Admin002 | admin2@gmail.com |    12345 |   441142 |
      | Admin3 | Admin003 | admin3@gmail.com |    12345 |  9089890 |
      | Admin4 | Admin004 | admin4@gmail.com |    12345 |  7889898 |
      
   Scenario: Positive Sceanrio - Admin - Click Add Option
   Given Once user enter the admin page click addadmin button.
	 When Enter the  all credials in admin and click the add permission.
	 Then Click the submit button in admin page.
	 
	 Scenario: Positive Sceanrio - Admin - Click Edit Option
   Given Once user enter the admin page click addadmin button.
	 When Enter the  all credials in admin and click the Edit permission.
	 Then Click the submit button in admin page.
	 
	 Scenario: Positive Sceanrio - Admin - Click Delete Option
   Given Once user enter the admin page click addadmin button.
	 When Enter the  all credials in admin and click the delete permission.
	 Then Click the submit button in admin page.
	 
	 
	 Scenario: Edit - Admin
	 Given User click the edit icon in admin
	 Then Check all values are present in admin
	 
	 Scenario: Negative Sceenario - Admin 
	  Given Once user enter the admin page click addadmin button.
    When Enter the  all credials in admin and dont select permission
    Then Click the submit button in admin page.
    But If it allow its bug.
	 