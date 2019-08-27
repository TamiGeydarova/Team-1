Feature: Google Feature Example

  @INSERT_TAG_HERE
  Scenario Outline: Search in google
    Given open Google webpage
    When search "<SearchingText>"
    Then result page was opened
    And first result is: "<SearchingResult>"

    Examples:
      | SearchingText      | SearchingResult                            |
      | Selenium WebDriver | Selenium WebDriver                         |
      | Cucumber Trainings | Online training - Cucumber School·Cucumber |

  @INSERT_TAG_HERE
  Scenario: Login into Google with incorrect user data
    Given open Google webpage
    And click login button
    And type user credentials
      | username | test1234  |
      | password | qwerty123 |
    When click login
    Then error message: Parole nav pareiza

