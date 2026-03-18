Feature: Submit Contact Us Form

  @wip
  Scenario: Verify contact us form submission
    Given user launch application
    When user click on Contact us button
    Then Contact Us page is displayed
    When user fill contact us data
    |name|email|subject|message|filePath|
    |thiru|thirutesting18031@yopmail.com|testing purpose|testing purpose message|C:\\Users\\DELL\\Downloads\\automation testing.txt|
    And clicked on submit
    Then contact us form submitted successfully
