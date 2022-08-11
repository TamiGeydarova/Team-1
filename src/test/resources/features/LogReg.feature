@Team1
Feature: Login After Registration Feature

  @US1S1T19_32
  Scenario: US1S1T19_32 Login and Logout with correct data
    Given I am on the shop webpage
    And click un My account button
    And click on Login button
    And write user credentials
      | username | odze@odze.lv |
      | password | 123password  |
    When click on login
    And I redirected to "Account" page
    And click un My account button
    And click logout button
    And redirect to logout page
    And click logout continue button
    Then redirect to shop webpage

  @US1S1T20
  Scenario: US1S1T20 Login with correct data in Capslock
    Given I am on the shop webpage
    And click un My account button
    And click on Login button
    And write user credentials
      | username | VIJA@ZEMITE.LV |
      | password | 159PAROLE      |
    When click on login
    Then I see error message

  @US1S1T21
  Scenario: US1S1T20 Login with incorrect user
    Given I am on the shop webpage
    And click un My account button
    And click on Login button
    And write user credentials
      | username | talu@talu.lv |
      | password | hahaupwnd     |
    When click on login
    Then I see error message wrong user or password

  @US1S1T24
  Scenario: US1S1T24 Login with special characters
    Given I am on the shop webpage
    And click un My account button
    And click on Login button
    And write user credentials
      | username | janedoe@gmail.com |
      | password | p@$$w0rd!@#$%     |
    When click on login
    And I redirected to "Account" page

  @US1S1T27
  Scenario: US1S1T27 Forgot password with unregistered email
    Given I am on the shop webpage
    And click un My account button
    And click on Login button
    And Click Forgotten
    And write forgotten email1
    When click continue
    Then I see error messageFP

  @US1S1T28
  Scenario: US1S1T28 Forgot password with incorrect email
    Given I am on the shop webpage
    And click un My account button
    And click on Login button
    And Click Forgotten
    And write forgotten email3
    When click continue
    Then I see error messageFP
  @US1S1T29
  Scenario: US1S1T29 Forgot password without email
    Given I am on the shop webpage
    And click un My account button
    And click on Login button
    And Click Forgotten
    When click continue
    Then I see error messageFP

  @US1S1T30
  Scenario: US1S1T30 Forgot password without @ email
    Given I am on the shop webpage
    And click un My account button
    And click on Login button
    And Click Forgotten
    And write forgotten email2
    When click continue
    Then I see error messageFP

  @US1S1T31
  Scenario: US1S1T31 Forgot password back clickable
    Given I am on the shop webpage
    And click un My account button
    And click on Login button
    And Click Forgotten
    When click back
    Then I redirected to "Login" page


