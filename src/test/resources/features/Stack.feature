@StackSutie
Feature: Testing the stack page of the DS Algo application 

@TestDemo_Stack_01
Scenario: The user should be on the stack page
Given The user landed on the home page after logged in 
When The user selects the stack option from the dropdown menu or clicks on Get Started button under Stack
Then The user should be redirected to stack page
 
@TestDemo_Stack_02
Scenario: The user is able to navigate to "operations in stack" page 
Given The user is on the stack page 
When The user clicks on the operations in the stack link 
Then The user should be redirected to operations in stack page 

@TestDemo_Stack_03
Scenario Outline: The user is able to navigate to page having tryeditor from operations in stack page 
Given The user is on the operations in stack page 
When The user clicks on Try here button for operations in stack page 
Then The user should be redirected to page having an tryEditor with a Run button for  operations in stack page 
And The user enter the valid python code in tryeditor page and click on Run button 
Then The user is presented with result for operations in stack


@TestDemo_Stack_04
Scenario Outline: The user is presented with error message for invalid python code for operations in stack page 
Given The user is on the tryEditor page for operations in stack page 
When The user enter the invalid python code for operations in stack page 
And The user click on the run button for operations in stack page 
Then The user will get an error message for operations in stack page 
 
@TestDemo_Stack_05
Scenario: The user is able to navigate to stack page and click on "Implementation " link
Given The user is in editor page and navigates to the stack page for implementation page
When The user clicks on the Implementation link 
Then The user should be redirected to Implementation page
 
@TestDemo_Stack_06
Scenario Outline: The user is able to navigate to page having tryeditor from Implementation page 
Given The user is on the Implementation page 
When The user clicks on Try here button for Implementation page
Then The user should be redirected to page having an tryEditor with a Run button and enter valid python code for Implementation page
And The user click on the run button for implementation page
Then The user is presented with result for implementation page
 
@TestDemo_Stack_07
Scenario Outline: The user is presented with error message for invalid code for Implementation page 
Given The user is on the tryEditor page for Implementation page 
When The user enter the invalid python code in tryeditor page  and click run button for Implementation page 
Then The user will get an error message for Implementation page
 
@TestDemo_Stack_08
Scenario: The user is able to navigate to stack page and click on "Applications " link
Given The user is in tryeditor page and navigates to stack page for application page 
When The user clicks on the Applications link 
Then The user should be redirected to Applications page
 
 @TestDemo_Stack_09
Scenario Outline: The user is able to navigate to page having tryeditor from Applications page 
Given The user is on the Applications page 
When The user clicks on Try here button for for Applications page 
Then The user should be redirected to page having an tryEditor with a Run button and enter python code for Applications page
And user click on run button for applications page 
Then The user is presented with the result for applications page  
 
@TestDemo_Stack_10
Scenario Outline: The user is presented with error message for invalid code in tryEditor page for Applications page 
Given The user is on the tryEditor page for Applications page 
When The user enter the invalid python code in tryeditor and clickon run button for Applications page 
Then The user will get an error message for Applications page 
 
@TestDemo_Stack_11
Scenario: The user is able to navigate to "practice Questions" in stack page 
Given The user is in tryeditor page and navigates to applications page 
When The user clicks on the practice Questions button 
Then The user should be directed to practice questions 
