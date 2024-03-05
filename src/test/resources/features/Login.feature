Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    When I enter email "varag@testpro.io"
    And I enter password "te$t$tudent1"
    And I click on login button
    Then I should be logged in
