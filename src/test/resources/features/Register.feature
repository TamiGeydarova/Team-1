Feature: Register scenario tested

  Background:
    Given I am on the shop homepage

  @US1S1T1
  Scenario: US1S1T1 Register happy path
    When I click on My account
    And I select Register in My account menu
    And I fill in all the input fields
      | name             | Joey             |
      | surname          | Tribbiani        |
      | email            | jthrib@gmail.com |
      | telephone        | 123456789        |
      | password         | password123      |
      | confirm password | password123      |
    And I press continue
    Then I see "Your Account Has Been Created!"message
    And I click continue in the message window
    Then I Get redirected to "My account" page

  @US1S1T8
  Scenario: US1S1T8 Register happy path (paswd with sp
  char)
    When I click on My account
    And I select Register in My account menu
    And I fill in all the input fields
      | name             | Joey                   |
      | surname          | Tribbiani              |
      | email            | jgjkjhhotrib@gmail.com |
      | telephone        | 123456789              |
      | password         | password123@!          |
      | confirm password | password123@!          |
    And I press continue
    Then I see "Your Account Has Been Created!"message
    And I click continue in the message window
    Then I Get redirected to "My account" page

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
      | name      | Rachel           |
      | surname   | Green            |
      | email     | raflg@friends.com |
      | telephone | 123456789        |
    And I fill in passwd section
      | password         | 12345  |
      | confirm password | 123456 |
    And I press continue
    Then I see "Password confirmation does not match password!" warning message




