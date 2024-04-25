#Author: your.email@your.domain.com

Feature: Branch Module

  Background: 
    Given Once user enter the homepage click the branch menu.


 Scenario: Positive Scenario - Edit - Check Branch ID is editable or not
    
    Given Click the Edit icon
    When Check the branch id is editable or not.


  Scenario: Edit - Check all value is present or not
    
    Given Click the Edit icon
    When Check the values present in all fields.

  Scenario: View the branch
    
    Given Click the view icon
    When Check the value present in all fields.
    
    
   Scenario: Delete the branch
   
   Given Click the delete icon
   Then Click the  Yes option

