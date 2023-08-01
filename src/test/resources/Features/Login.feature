Feature: Login Functionality of FaceBook

  Background: 
    Given Launch the FacebookURL

  Scenario: To Validate login using Valid UserName and Password
    When User enter valid username and password
    And Click login button
    Then User should be in homepage of the facebook

  Scenario: To Validate login using Invalid UserName and password
    When User enter Invalid username and Invalid password
    And Click login button
    Then User should be in invalid credential page
