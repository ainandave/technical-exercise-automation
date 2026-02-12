Feature: Purchase 7-day SIM plan with declined payment

  Scenario: Payment should fail when declined card is used
    Given user is on the homepage
    When user selects 7 day sim plan
    And user completes checkout with declined credit card
    Then payment error message should be displayed
