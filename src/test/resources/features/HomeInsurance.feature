@all
Feature: Policyexpert home insurance test page

  Scenario Outline:
    Given I open the home insurance page "https://insurance.policyexpert.co.uk/home"
    And I enter the title "<title>"

  Examples:
    |title|
    | Mr    |