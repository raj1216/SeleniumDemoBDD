Feature: Add employee in PIM
Background:
  Given enter username and password
  And click login
  @PIM
  Scenario Outline: <testname> Add employee with valid data
    Given Click on PIM link on left navigation pane
    When click on Add Employee button
    And enter "raj" in FirstName
    And enter "avhad" in LastName
    And Enter "6758" in "Employee Id" textbox
    And click on save button
    Then validate page title is "Personal Details"
    And Enter "12" in "Other Id" textbox
  #  When Enter "123456" in "Driver License Number" textbox
    And Enter "8965" in "SSN Number" textbox
    And Enter "Indian Army" in "Military Service" textbox
    And click on save button on personal details page

Examples:
    |testname|
    |TC_01        |

