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
      When the user enters "new1" into the "New Password" box
      And the user enters "new1" into the "Verify Password" box
      And the new password is valid
      Then the users password can be updated

    Scenario: Users new passwords do not match
      When the user enters "new1" into the "New Password" box
      And the user enters "new2" into the "Verify Password" box
      Then an error message is displayed stating "Passwords do not match"
      And users password is not updated

    Scenario: User enters valid new password
      When the new password is identical in both boxes
      And the new password is more than 2 characters
      And the new password contains at least 1 number
      Then the users password can be updated

    Scenario Outline: User enters invalid new password
      When the new password is identical in both boxes
      And the new password is <Invalid password>
      Then an error message is displayed
      And the users password is not updated
      Examples:
        | Invalid password            |
        | less than 2 characters      |
        | doesn't contain any numbers |
