Feature: HomePage Scenarios

  Scenario: Check the month and year is shows correctly
    Given Once user enter the homepage.
    When Check the year,date,month shows correcly or not.
    Then Verify it shows correct month and year by using our local month and year.

  Scenario: Edit the institute name and verify the value has been change in homepage
    Given Once user enter the homepage and click the edit icon.
    When Firstly clear the existing data and add new value.
    Then Click Submit icon first then click Close icon.
    And Check the values has been changed in homepage.

  Scenario: Click the edit institute icon and do some action
    Given Once user enter the homepage and click the edit icon.
    When User can able to edit the  password and email fields
    Then Click Submit icon  then click Close icon.

  Scenario: Negative Testcase - In Edit - Mobile no field enter the negative value and how its behave
    Given Once user enter the homepage and click the edit icon.
    When User enter the negative value in mobile number field like "-233"
    Then Click Submit icon  if its allow there is a bug.

  Scenario: Negative Testcase1 - Edit - Clear the all data and check how it behave
    Given Once user enter the homepage and click the edit icon.
    When User clear the editable data
    Then Click the submit icon and check check how it behave
	
	Scenario: Click the profile icon and check all the data is present or not.
	Given Click the profile icon.
	Then Check all values showing or not in profile view.
	
	