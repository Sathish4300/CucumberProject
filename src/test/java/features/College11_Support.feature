Feature: College - Support Module

Background:
	Given Once user enter the homepage click the support menu.

	
 Scenario: Positive Scenario - Support Module
    Given Once user enter the admin page click addSupport button.
    When Enter the  all credials in support.
    Then Check the data has been present or not in support page. 
    
 Scenario: Without enter anything click submit button in support
    Given Once user enter the admin page click addSupport button.
    When Click the submit button in support page.
    Then Check how it behave in support page.
    
  Scenario: Without enter anything click submit and add button in support
    Given Once user enter the admin page click addSupport button.
    When Click the submit and add button in support page.
    Then Check how it behave in support page whether it shows error message or not.
    
   Scenario: Enter the mandatory fields in support page
   	Given Once user enter the admin page click addSupport button.
   	When Enter the mandatatory fields only.
   	Then Check how its behave in support page.
   	
   Scenario: Upload a big mb videos in doc how it behaves.
   	Given Once user enter the admin page click addSupport button.
   	When Enter the credentials and try to upload more mb data.
   	Then Check whether the videos has been upload oe not.
   	
   Scenario: Search module in support page
    Given Search some word like "V" in support.
    When Check All words contains V char in support.