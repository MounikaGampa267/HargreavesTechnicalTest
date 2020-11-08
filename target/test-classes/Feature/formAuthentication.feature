Feature: Testing the features of a website

  Scenario: Verifying the Form Authentication Feature
    Given Initializing browser for Form Authentication
    When clicking on Form Authentication and Enter usename and password link
    And Clicking on dynamic link and loading and verifying the hello wold
    And clicking on javascript
    Then verify the alert message dispalyed correct or not
