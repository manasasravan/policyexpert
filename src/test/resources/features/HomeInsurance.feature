@all
Feature: Policyexpert home insurance test page

  Scenario Outline:
    Given I open the home insurance page "https://insurance.policyexpert.co.uk/home"
    And I enter the title "<title>"
    And I enter the first name "<firstName>"
    And I enter the last name "<lastName>"
    And I enter date of birth "<dateOfBirth>"

  Examples:
    |title| firstName |lastName|dateOfBirth|
    | Mr    | Joe | Root       |  01-01-1990  |