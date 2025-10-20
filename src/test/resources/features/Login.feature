Feature: Verify User Login

@login
Scenario Outline: User login with valid credentials
Given user launch application
When user click on signUpAndSignIn button
Then signUpAndSignIn page is displayed
When user enters <email_id> and <password>
And clicked on login
Then user logged in successfully

Examples:
|		email_id								|	password	|
|		thirutestingautomation@yopmail.com		|	Test@123	|

