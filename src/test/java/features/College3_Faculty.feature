Feature: College - Faculty Module

  Background: 
    Given Once user enter the homepage click the faculty menu.

  Scenario: Positive Sceanrio for Faculty Module
    Given Click the add faculty icon.
    When Enter the all credentials like "robert","FA-003","32","Phd","robert@gmail.com","12345","6436464643535","04/03/2000","10/05/2020","A+ve","fghjkm,","fghn","5678","gbhnjnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
    Then User click the Submit button.
    And Check the count of the faculty in homepage.
    
   Scenario: Without Enter anything click submit icon and check how its behave
    Given Click the add faculty icon.
    When Without enter anything click the submit button
    Then Check the urls how its behave
    
   Scenario: Check the date why it shows null
   	Given Grab the text  in faculty page
   	And Click the add faculty icon.
   	When Without enter date fields and enter the remaining field like "robert1","FA-004","324","Phd","robert1@gmail.com","12345","6436464643535","A+ve","fghjkm,","fghn","5678","gbhnjnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
		Then User click the Submit button.
		And Check how it behaves.
		
		Scenario: Negative Scenario1 for Faculty Module
    Given Click the add faculty icon.
    When Enter the all credentials like "robert","FA-003","32","Phd","robert@gmail.com","12345","6436464643535","04/03/2000","10/05/2020","A+ve","fghjkm,","fghn","5678","gbhnjnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
    Then User click the Submit button.
    And Error Message showing or not.
    
    Scenario: Negative Scenario2 in Date Fields
     Given Click the add faculty icon.
     When User Select the upcoming date in DOB Fields and enter the remaining details like "robert2","FA-005","325","Phd","robert5@gmail.com","12345","6436464643535","A+ve","fghjkm,","fghn","5678","gbhnjnnnnnnnnnnnnnnnnnnnnnnnnnnnnn".
     Then User click the Submit button.
     And Check the condition is True or False.
     
     Scenario: Negative Scenario3 in Email,Mobile,Pincode Fields
     Given Click the add faculty icon.
     When Enter the all credentials like "robert","FA-003","32","Phd","opkl@gmailcom","12345","-6436464643535","04/03/2000","10/05/2020","A+ve","fghjkm,","fghn","-5678","gbhnjnnnnnnnnnnnnnnnnnnnnnnnnnnnnn"
     Then User click the Submit button.
     And It need to shows error message.
     
     Scenario: Postive Scenario - Search some char in faculty search box and check it contains this char
     Given User search the some word in search box like "a".
     Then Grab all the text and check all the word this char is present or not.
     
     Scenario: Negative Scenario - Search irrelevant char and check how its behave
     Given User search irrelevant word like "k".
     Then Error Text is showing or not.
     
     Scenario: Edit - Some Faculty
     Given Click the Edit icon.
     When Edit the name like "23".
     Then User click the Update button.
     And Check values has been changed or not.
     
     
     Scenario: Delete Some Faculty
     Given Click the Delete icon
     When User click the yes option
     Then Check the deleted faculty is present or not.
      
     
     