
Feature: NonSuccessfulLogin
    Scenario: SearchTestRunner

      Given I am on new project login page
      When I fill login "login" and pass "pass"
      Then  result is "true"

      Given I am on new project login page
      When I fill login "11111" and pass "p111111ass"
      Then  result is "true"

      Given I am on new project login page
      When I fill login "" and pass "0"
      Then  result is "true"

