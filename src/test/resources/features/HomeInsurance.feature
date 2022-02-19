@all
Feature: Policyexpert home insurance test page

  Scenario Outline:
    Given I open the home insurance page "https://insurance.policyexpert.co.uk/home"
    And I enter the title "<title>"
    And I enter the first name "<firstName>"

  Examples:
    |title| firstName |
    | Mr    | Joe |