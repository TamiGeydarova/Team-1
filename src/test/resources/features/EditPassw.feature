Feature: Test password changing
  @US2S1T30
  Scenario: US2S1T30 Change password with valid input
    Given I am on the shop webpage
    And click un My account button
    And click on Login button
    And write user credentials
      | username | aija@klava.lv |
      | password | 123parole  |
    And click on login
    And I redirected to "Account" page
    And Choose Change My Password
    And write password credentials
      | password     | 123parole |
      | confpassword | 123parole |
    When click continue
    Then get success message

  @US2S1T32
  Scenario: US2S1T32 Change password empty fields
    Given I am on the shop webpage
    And click un My account button
    And click on Login button
    And write user credentials
      | username | lina@zeme.lv |
      | password | 124parole  |
    And click on login
    And I redirected to "Account" page
    And Choose Change My Password
    And delete old password
    And delete old password confirmation
    When click continue
    Then get password error message
  @US2S1T33
  Scenario: US2S1T33 Change password not same
    Given I am on the shop webpage
    And click un My account button
    And click on Login button
    And write user credentials
      | username | aija@saule.lv |
      | password | 159parole  |
    And click on login
    And I redirected to "Account" page
    And Choose Change My Password
    And write password credentials
      | password     | 126password |
      | confpassword | 127password |
    When click continue
    Then get error message
  @US2S1T34
  Scenario: US2S1T34 Change password second empty
    Given I am on the shop webpage
    And click un My account button
    And click on Login button
    And write user credentials
      | username | aija@zeme.lv |
      | password | 123parole  |
    And click on login
    And I redirected to "Account" page
    And Choose Change My Password
    And write password credentials
      | password     | 126password |
    And delete old password confirmation
    When click continue
    Then get error message 3

  @US2S1T35
  Scenario: US2S1T35 Change password check back
    Given I am on the shop webpage
    And click un My account button
    And click on Login button
    And write user credentials
      | username | aija@zeme.lv |
      | password | 123parole  |
    And click on login
    And I redirected to "Account" page
    And Choose Change My Password
    When click back
    Then I redirected to "Account" page
