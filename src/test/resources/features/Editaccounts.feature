Feature: Edit account Example

  @Team11
  Scenario: I am on the submenu User can edit the personal Information.
    Given User should be on Homepage
    When User select on my account
    And I enter Email address and password
      | E-mail                    | Password  |
      | ajaiinindia1996@gmail.com | Shiva1996 |
    And I click Login
    Then select address book
    And I click Edit
    And Fill up the input fields
      | name      | Shiva         |
      | surname   | R             |
      | address   | Lacplesa iela |
      | cty       | Riga          |
      | postCde   | 1003          |
    And Press Continue

    @Team1
    Scenario: The user can change the password
      Given User should be on Homepage
      When User select on my account
      And I enter Email address and password
        | E-mail                    | Password  |
        | ajaiinindia1996@gmail.com | Shiva1996 |
      And I click Login
      And change your password from submenu "Shiva@1996"
