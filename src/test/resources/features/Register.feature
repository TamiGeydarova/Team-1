@Team1
Feature: Register scenario tested

  Background:
    Given I am on the shop homepage

  @US1S1T1
  Scenario: US1S1T1 Register happy path
    When I click on My account
    And I select Register in My account menu
    And I fill in all the input fields
      | name             | Joey              |
      | surname          | Tribbiani         |
      | email            | jhshrb@gmarel.com |
      | telephone        | 123456789         |
      | password         | password123       |
      | confirm password | password123       |
    And I press continue
    Then I see "Your Account Has Been Created!" message
    And I click continue in the message window
    Then I Get redirected to My account page

  @US1S1T8
  Scenario: US1S1T8 Register happy path (paswd with sp
  char)
    When I click on My account
    And I select Register in My account menu
    And I fill in all the input fields
      | name             | Joey            |
      | surname          | Tribbiani       |
      | email            | tefib@gmail.com |
      | telephone        | 123456789       |
      | password         | password123@!   |
      | confirm password | password123@!   |
    And I press continue
    Then I see "Your Account Has Been Created!" message
    And I click continue in the message window
    Then I Get redirected to My account page

  @US1S1T9
  Scenario: US1S1T9 Register passwd too short
    When I click on My account
    And I select Register in My account menu
    And I fill in all the input fields
      | name             | Darta                |
      | surname          | Roze                 |
      | email            | darohftzee@gmail.com |
      | telephone        | 123456789            |
      | password         | 123                  |
      | confirm password | 123                  |
    And I press continue
    Then I get "Password must be between 4 and 20 characters!" warning message

  @US1S1T10
  Scenario: US1S1T10 Passwd snd confirm passwd not matching
    When I click on My account
    And I select Register in My account menu
    And I fill the input fields no passwd
      | name      | Rachel            |
      | surname   | Green             |
      | email     | raflg@friends.com |
      | telephone | 123456789         |
    And I fill in passwd section
      | password         | 12345  |
      | confirm password | 123456 |
    And I press continue
    Then I see "Password confirmation does not match password!" warning message

  @US1S1T11_12_15
  Scenario Outline: US1S1T11_12_15 register with blank, privacy policy unticked/ticked
    When I click on My account
    And I select Register in My account menu
    And I leave all input fields empty
      | name             |  |
      | surname          |  |
      | email            |  |
      | telephone        |  |
      | password         |  |
      | confirm password |  |
    And I press continue
    Then I see error messages
    And I tick the privacy policy
    Then I see error messages for input fields only
    And  I fill all fields except email
      | name             | Vita      |
      | surname          | Vita      |
      | email            |           |
      | telephone        | 123456789 |
      | password         | 123       |
      | confirm password | 123       |
    Then I see email invalid error message
    And I fill all fields except password
      | name             | Vita           |
      | surname          | Vita           |
      | email            | vivta@vita.com |
      | telephone        | 123456789      |
      | password         |                |
      | confirm password |                |
    Then I see password invalid message
    Examples:
      | name | surname | email         | telephone | password | confirm password |
      |      |         |               |           |          |                  |
      | Vita | Vita    |               | 123456789 | 123      | 123              |
      | Vita | Vita    | vita@vita.com | 123456789 |          |                  |


  @US1S1T18
  Scenario: US1S1T18 Register with credentials of existing user
    When I click on My account
    And I select Register in My account menu
    And I fill in all the input fields
      | name             | Joey                    |
      | surname          | Tribbiani               |
      | email            | joeytribbiani@gmail.com |
      | telephone        | 123456789               |
      | password         | password123             |
      | confirm password | password123             |
    And I press continue
    Then I can see "Warning: E-Mail Address is already registered!" message



