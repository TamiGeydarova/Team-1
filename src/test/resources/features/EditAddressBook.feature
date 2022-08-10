Feature:  Edit Address book

  Background:
    Given I am on Account login webpage
    Then I login into my account

    @US2S1T8
    Scenario: US2S1T8
      When I am on the Address Book page
      Then I click on New Address button
      And I fill in all the input fields
        | First Name      | Sarah              |
        | Last Name       | O'Conor            |
        | Address 1       | Grove street 69    |
        | City            | LosSantos          |
        | Post Code       | ls                 |
        | Country         | United States      |
        | Region / State  | California         |
      Then I press continue
      Then I see a message

    @US2S1T9
    Scenario: US2S1T9
      When I am on the Address Book page
      Then I click on New Address button
      And I fill in all the input fields
        | First Name      | Michal              |
        | Last Name       | Jackson             |
        | Address 1       | Baker street 77     |
        | City            | London              |
        | Post Code       | GB777               |
        | Country         | United Kingdom      |
        | Region / State  | Dundee              |
      Then I press continue
      Then I see a message

    @US2S1T10
    Scenario: US2S1T10
      When I am on the Address Book page
      Then I see a default address
      And I delete this default address
      Then I confirm the action
      Then I see a message

    @US2S1T11
    Scenario: US2S1T11
      When I am on the Address Book page
      Then I click on Edit button
      And I fill in all the input fields
        | First Name      | Michal              |
        | Last Name       | Jackson             |
        | Address 1       | Baker street 77     |
        | City            | London              |
        | Post Code       | GB777               |
        | Country         | United Kingdom      |
        | Region / State  | Dundee              |
      Then I press continue
      Then I see a message

    @US2S1T12
    Scenario: US2S1T12
      When I am on the Address Book page
      Then I click on Edit button
      And I fill in all the input fields
        | First Name      |                       |
        | Last Name       |                       |
        | Address 1       |                       |
        | City            |                       |
        | Post Code       |                       |
        | Country         | --- Please Select --- |
        | Region / State  |  --- None ---         |
      Then I press continue
      Then I see warning messages and stay the same page

#    @US2S1T13
#    @US2S1T14
#    @US2S1T15
#    @US2S1T16
#    @US2S1T17
#    @US2S1T18
#    @US2S1T19