@FID10-288
Feature: Login Functionality
  User Story:
  As a user, I should be able to log in so that I can land on homepage.
  Background:
    Given user is on fidexio login page
@FID10-276
  Scenario:
  1-Users can log in with valid credentials
  (We have 5 types of users but will test only 2 user: PosManager, SalesManager)
    SalesManager
    When user(salesManager)enters "salesmanager15@info.com" as username and "salesmanager" as password.
    And user clicks to login button
    Then user(SalesManager) is on the homepage


@FID10-274
  Scenario:
  AC: 1-Users can log in with valid credentials
  (We have 5 types of users but will test only 2 user: PosManager, posManager)
  posManager
    When user(posManager)enters "posmanager15@info.com" as username and "posmanager" as password.
    And user clicks to login button
    Then user(posManager) is on the homepage
@FID10-278
Scenario:
   AC: 2-"Wrong login/password" should be displayed for invalid
    (valid username-invalid password and invalid username-valid password) credentials
      When user enters " " as invalid username and " " as invalid password
      And user clicks to login button
      Then user should see the "Wrong login/password" message on the login page after providing invalid credentials
@FID10-280
 Scenario Outline:
 "Please fill out this field" message should be displayed if the username or password field is empty
    When user enters only an "<email>" or "<password>"
    Then  user should see warning message to fill empty fields when trying to log in
    Examples:
      | email                   | password   |
      | salesmanager15@info.com |            |
      |                         | posmanager |
      |                         |            |

@FID10-282
  Scenario:
         AC: 4-User land on the ‘reset password’ page after clicking on the "Reset password" link
          When user clicks on the "Reset Password" link to  reset password
          Then user will be redirected to the reset password page
@FID10-284
          Scenario:
          AC:5-User should see the password in bullet signs by default
            When user enters "salesmanager" as password
            Then the user should see the password in bullet signs by default
@FID10-287
            Scenario:
           AC:6- Verify if the ‘Enter’ key of the keyboard is working correctly on the login page
              When user enters "salesmanager15@info.com" as username and "salesmanager" as password.
              And user should  press the Enter key on the keyboard
              Then user should be logged in to the system










