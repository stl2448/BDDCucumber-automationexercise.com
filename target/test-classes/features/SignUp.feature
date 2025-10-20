Feature: Validate signUp

Scenario Outline: verify sign up filling all necessary details
Given user launch application
When user click on signUpAndSignIn button
Then signUpAndSignIn page is displayed
When user enter <name> and <email_address> in signUp section
And user clicked on signUp button
Then signUp Page is displayed
When user enter all necessary details
|title|password|day|month|year|firstName|lastName|company|address|country|state|city|zipcode|mobile|
|mr|Test@123|10|March|1998|thirumalesh|stl|cognizant|hyderabad|India|Telangana|Hyderabad|GF2 E45|1212121212|
And opted for newsletter and special offers checkboxes
And clicked on CreateAccount button
Then Account created message is displayed
When user clicked on continue button
Then Home page is displayed with logout button
And user clicked on delete account button
Then account deleted message is displayed


Examples:
|name|email_address|
|thiru|thirutesting2110@yopmail.com|
