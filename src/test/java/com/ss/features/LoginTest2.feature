Feature: NonSuccessfulLogin
  Scenario Outline: SearchTestRunner

    Given I am on new project login page
    When I fill login "<username>" and pass "<password>"
    Then  result is "true"

  Examples:
      | username    | password   |
      | Test        | !23        |
      | Test1       | !23        |
      | Test2       | !23        |
      | Test3       | !23        |
      | Test4       | !23        |
      | Test5       | !23        |
      | Test6       | !23        |
      | Test7       | !23        |
      | Test8       | !23        |
      | Test9       | !23        |
