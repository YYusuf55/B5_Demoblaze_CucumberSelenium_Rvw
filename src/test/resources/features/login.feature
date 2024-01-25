Feature: Login Test
  # Agile story :  As a user I should be able to login with valid credentials
  Background:
    Given The user navigates to website

  Scenario: Positive Login Test 1 without parameter
    When The user  clicks on login button and enters valid credentials
    Then The user verifies welcome message


  Scenario: Positive Login Test 2 with parameter
    When The user clicks on login button and enters "JhonyQ" "Test1234" credentials
    Then The user verifies welcome "JhonyQ" message


  Scenario Outline: : Positive Login Test 3 with scenario outline
    When The user clicks on login button and enters "<username>" "<password>" credentials
    Then The user verifies welcome "<username>" message
    Examples:
      | username | password |
      | JhonyQ   | Test1234 |

  @wip
  Scenario Outline: : Positive Login Test 4 with scenario outline and data table
    When The user  clicks on login button and enters following credentials
      | username | <user_username> |
      | password | <user_password> |
    Then The user verifies welcome "<user_username>" message
    Examples:
      | user_username | user_password |
      | JhonyQ        | Test1234      |

    #negative login test
  @t_negativeLogin
  Scenario Outline: Negative Login Test 5 with Scenario Outline
    When The user clicks on login button and enters "<invalid_username>" "<invalid_password>" credentials
    Then The user verifies invalid access message is "<message>"
    Examples:
      | invalid_username | invalid_password   | message                                |
      | yusuff94         |                    | Please fill out Username and Password. |
      |                  | 0883d0883d         | Please fill out Username and Password. |
      | yusuf94_invalid  | 0883d0883d         | User does not exist.                   |
      | yusuff94          | 0883d0883d_invalid | Wrong password.                        |
      |                  |                    | Please fill out Username and Password. |
      | yusuff94_invalid | 0883d0883d_invalid | User does not exist.                   |
