Feature: Branch Module

  Background: 
    Given Once user enter the homepage click the branch menu.

  Scenario: Positive Scenario for Branch Module
    Given Click the add branch icon.
    When Enter the all credentials like "Velam","VEL - 2","velam@gmail.com","56677889","677889","12345","vvv","gsdfdgabafbff","gsasgagassa","dsssdsd","3243","20"
    Then User click the Submit button.
    And Check the count of the faculty.

  Scenario: Negative Scenario1 for Branch Module
    Given Click the add branch icon.
    When Enter the all credentials like "Velam","VEL - 2","velam@gmail.com","56677889","677889","12345","vvv","gsdfdgabafbff","gsasgagassa","dsssdsd","3243","20"
    Then User click the Submit button.
    And Error Message showing or not.

  Scenario: Positive Scenario - Add a new branch and check created date and time
    Given Click the add branch icon.
    When Enter the all credentials like "Velam3","VEL - 3","velam3@gmail.com","56677889","677889","12345","vvv","gsdfdgabafbff","gsasgagassa","dsssdsd","3243","20"
    Then User click the Submit button.
    And Check the created date and time.

  Scenario: Without Enter anything click submit icon and check how its behave
    Given Click the add branch icon.
    When Without enter anything click submit button
    Then Check the url how its behave

  Scenario Outline: Positive Scenario - Add two data simutaneously by using submit and add button.
    Given Click the add branch icon.
    When Enter the all credentials like "<branchName>" "<branchID>" "<email>" "<landlineNumber>" "<mobileNumber>" "<password>" "<conactPerson>" "<address1>" "<address2>" "<area>" "<pincode>" "<cloud>"
    And click submit and add icon
    Then Enter the all credentials like "<branchName>" "<branchID>" "<email>" "<landlineNumber>" "<mobileNumber>" "<password>" "<conactPerson>" "<address1>" "<address2>" "<area>" "<pincode>" "<cloud>"
    And Check the count.

    Examples: 
      | branchName | branchID | email         | landlineNumber | mobileNumber | password | conactPerson | address1 | address2 | area    | pincode | cloud |
      | dsds       | faa1411  | fa@gamil.com  |         243131 |         4352 |    12345 | dfbdbd       | fdsfbdfs | iokhjkj  | hghvbjj |     789 |  0998 |
      | afdd       | gds231   | fda@gamil.com |          89900 |        78789 |    12345 | iuhj         | jbnn     | jhjk     | bnkm    |   76778 | 76889 |

  Scenario: Negative Scenario2 - In email id and mobile number and cloud also do negative scenarios values check how it behaves.
    Given Click the add branch icon.
    When Enter the all credentials like "Velam4","VEL - 4","velam4@gmailcom","-56677889","677889","12345","vvv","gsdfdgabafbff","gsasgagassa","dsssdsd","3243","-20"
    Then User click the Submit button.
    And It need to show error message.

  Scenario: Positive Scenario - Search some char in search box and check how its behave
    Given Search some word like "V".
    When Check All words contains V char.

  Scenario: Negative Scenario Search irrelevant char and check how it behave
    Given Search some word like "q".
    When Error message need to shows.
    
   
