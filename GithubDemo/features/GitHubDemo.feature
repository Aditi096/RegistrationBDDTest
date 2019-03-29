@execute
Feature: Github Login functionality Check

Scenario: User is trying to signin in Github using invalid username and password

Given User is on Github Login Page
When User enter invalid username and password 
Then 'Incorrect Username and Password' Message should display

Scenario:  User is trying to signin in Github using valid username and password

Given  User is on Github Login Page
When User enter valid username and password
Then User should successfullt signin on his his Github account