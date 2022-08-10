Feature: Register scenario tested

  Background:
    Given I am on the shop homepage

  @US1S1T1
  Scenario: US1S1T1
    When I click on My account
    And I select Register in My account menu
    And I fill in all the input fields
      | name             | Joey                    |
      | surname          | Tribbiani               |
      | email            | jfdfosephtribbiani@gmail.com |
      | telephone        | 123456789               |
      | password         | password123             |
      | confirm password | password123             |
    And I press continue
    Then I see "Your Account Has Been Created!"message
    And I click continue in the message window
    Then I Get redirected to "My account" page











