Feature:  Edit Address book

  Background:
    Given I am on Account login webpage
    Then I login into my account

    @US2S1T8
    Scenario: US2S1T8
      When I on the Address Book page
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
      Then I see a successful message