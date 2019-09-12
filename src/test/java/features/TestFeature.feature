Feature: validate login functionality

Scenario: check with valid logins
Given browser opened with open URL
When user sees login page enter "Admin" and "admin123"
Then redirect to homepage and
Then close browser
