@Team1
Feature: Edit Address Book1

  Background:
    Given I am on the shop homepage

  @US2S1T20
  Scenario: US2S1T20 Address Book Empty City Field
    When I click on My account
    And I select Login in My account menu
    And I enter Email address and Password
      | email    | aleksandrshoperskis@gmail.com |
      | password | 12345                         |
    And I click Login button
    Then I click on Address Book button
    And I click Edit button
    And I clear information from City field
    And Click continue button
    Then Check error message

  @US2S1T21_23
  Scenario: US2S1T21_23 Edit Address Book Select Country and Region
    When I click on My account
    And I select Login in My account menu
    And I enter Email address and Password
      | email    | aleksandrshoperskis@gmail.com |
      | password | 12345                         |
    And I click Login button
    Then I click on Address Book button
    And I click Edit button
    And I choose Country Albania from dropdown menu
    And I choose Region Berat from dropdown menu
    And Click continue button
    Then Check confirmation message
   Then Check Country and Region are updated

  @US2S1T22
  Scenario: US2S1T22 Edit Address Book Select Empty Country filed in drop down menu
    When I click on My account
    And I select Login in My account menu
    And I enter Email address and Password
      | email    | aleksandrshoperskis@gmail.com |
      | password | 12345                         |
    And I click Login button
    Then I click on Address Book button
    And I click Edit button
    And I clear Country from dropdown menu
    And Click continue button
    Then Check error message for Empty Country field

  @US2S1T24
  Scenario: US2S1T24 Select the Empty Region / State field in the dropdown menu
    When I click on My account
    And I select Login in My account menu
    And I enter Email address and Password
      | email    | aleksandrshoperskis@gmail.com |
      | password | 12345                         |
    And I click Login button
    Then I click on Address Book button
    And I click Edit button
    And I clear Region from dropdown menu
    And Click continue button
    Then Check error message for Empty Region filed
