@spaQuote
Feature: Publish Quote
  Scenario: Happy path for spa quote creation
    Given PROS published spa quote information from json "pros_spa_quote_create_input.json" to pros-quote topic
    When spa quote should be mapped with mapping condition correctly and saved in quote table successfully 10 seconds later
    Then pds should publish the payload as "pros_spa_quote_created_output.json" for "CREATED" event in pds-lubes-spa-quote topic

  Scenario: Sad path for sending duplicate spa quote
    Given PROS published spa quote information from json "pros_spa_quote_create_input.json" to pros-quote topic
    When spa quote should be mapped with mapping condition correctly and saved in quote table successfully 10 seconds later
    Then pds should not publish any message to pds-lubes-spa-quote topic