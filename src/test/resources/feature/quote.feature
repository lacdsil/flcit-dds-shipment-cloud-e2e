@quote
Feature: Publish Quote
  Scenario: Happy path for quote creation
    Given PROS published quote information from json "pros_quote_create_input.json" to pros-quote topic
    When quote should be mapped with mapping condition correctly and saved in quote table successfully 10 seconds later
    Then pds should publish the payload as "pros_quote_created_output.json" for "CREATED" event in pds-lubes-quote topic

  Scenario: Sad path for sending duplicate quote
    Given PROS published quote information from json "pros_quote_create_input.json" to pros-quote topic
    When quote should be mapped with mapping condition correctly and saved in quote table successfully 10 seconds later
    Then pds should not publish any message to pds-lubes-quote topic