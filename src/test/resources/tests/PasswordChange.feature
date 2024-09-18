#noinspection CucumberUndefinedStep
Feature: The user can change their own password

  Rule: As a user
  I want to be able to change my own password within the guidelines of password policy
  So that the integrity of my account security requirements are met.

    Background:
      Given Account exists with username "JohnSmith" and password "password123"
      And username "JohnSmith" is entered into the username box
      And password "password123" is entered into the password box

    Scenario: User enters new password into both boxes
      Given the new password is valid
      When the user enters "new1" into the "New Password" box
      And the user enters "new1" into the "Verify Password" box
      Then the users password can be updated

    Scenario: User enters valid new password
      When the new password is identical in both boxes
      And the new password is more than 2 characters
      And the new password contains at least 1 number
      Then the users password can be updated

    Scenario: User enters invalid new password
      When the new password is identical in both boxes
      And the new password is less than 2 characters
      And the new password contains at least 1 number
      Then an error message is displayed and the users password is not updated