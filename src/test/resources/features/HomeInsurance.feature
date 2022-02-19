@all
Feature: Policyexpert home insurance test page

  Scenario Outline:
    Given I open the home insurance page "https://insurance.policyexpert.co.uk/home"
    And I enter the title "<title>"
    And I enter the first name "<firstName>"
    And I enter the last name "<lastName>"
    And I enter date of birth "<dateOfBirth>"
    And I enter marital status "<maritalStatus>"
    And I enter occupation "<occupation>"
    And I enter other occupation "<otherOccupation>"
    And I enter main phone number "<phoneNumber>"
    And I enter email address "<emailAddress>"
    And I enter financial questions "<financialQuestion>"

    Examples:
      | title | firstName | lastName | dateOfBirth | maritalStatus | occupation    | otherOccupation | phoneNumber | emailAddress            |financialQuestion|
      | Mr    | Joe       | Root     | 1-January-1990  | Married       | IT Consultant | No              | 01234567890 | vketipisz@qmetric.co.uk |No           |