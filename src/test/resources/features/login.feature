Feature: Logging into the application
  Scenario: Logging into the system for the users in the data table
    Given the user is at the login page with endpoint "/login"
    When the user enters the following user details
    | abdullah | tariq | abdullahtariq97@yahoo.com |
    | tariq | masud | tariq_masud50@yahoo.com |
    | lubna | tariq | lubnatariq87@gmail.com |
    Then the application should say "login sucessfull"
