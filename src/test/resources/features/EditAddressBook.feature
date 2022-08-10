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

    @US2S1T13
    Scenario Outline: US2S1T13
      When I am on the Address Book page
      Then I click on Edit button
      And I change the first name <short>
      Then I press continue
      Then I see warning messages and stay the same page
      And I change the first name <long>
      Then I press continue
      Then I see warning messages and stay the same page
      Examples:
        | short | long |
        |   J   |   Jvjaijbaefbukvabfkbvbrbfavrbfbvbvrubvuaerfbuvarnfbusetnifuvseubnuvsenbuvsvehrguivshetubhsbktubvustbusfbbstfy   |

    @US2S1T14
    Scenario: US2S1T14
      When I am on the Address Book page
      Then I click on Edit button
      And I clean the first name
      Then I press continue
      Then I see warning messages and stay the same page

    @US2S1T15
    Scenario Outline: US2S1T13
      When I am on the Address Book page
      Then I click on Edit button
      And I change the last name <short>
      Then I press continue
      Then I see warning messages and stay the same page
      And I change the last name <long>
      Then I press continue
      Then I see warning messages and stay the same page
      Examples:
        | short | long |
        |   J   |   Jvjaijbaefbukvabfkbvbrbfavrbfbvbvrubvuaerfbuvarnfbusetnifuvseubnuvsenbuvsvehrguivshetubhsbktubvustbusfbbstfy   |

    @US2S1T16
    Scenario: US2S1T16
      When I am on the Address Book page
      Then I click on Edit button
      And I clean the last name
      Then I press continue
      Then I see warning messages and stay the same page

    @US2S1T17
    Scenario Outline: US2S1T17
      When I am on the Address Book page
      Then I click on Edit button
      And I change the Address1 <address>
      Then I press continue
      Then I see a message
      Examples:
        | address |
        |Rīgas iela 153|

    @US2S1T18
    Scenario: US2S1T18
      When I am on the Address Book page
      Then I click on Edit button
      And I clean the Address1
      Then I press continue
      Then I see warning messages and stay the same page

    @US2S1T19