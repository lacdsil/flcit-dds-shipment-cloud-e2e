@spaPrice
Feature: Publish SPA Price
  Scenario: Happy path for spa price creation
    Given PROS published spa price information from json "pros_spa_price_created_input.json" to pds-list-price-condition topic
    When spa price should be mapped with mapping condition correctly and saved in spa_price table successfully 10 seconds later
    Then pds should publish the payload as "pds_spa_price_created_output.json" for "CREATED" event in pds-lubes-spa-price topic

  Scenario: Happy path for spa price change
    Given PROS published spa price information from json "pros_spa_price_changed_input.json" to pds-list-price-condition topic
    When spa price should be mapped with mapping condition correctly and saved in spa_price table successfully 10 seconds later
    Then pds should publish the payload as "pds_spa_price_changed_output.json" for "CHANGED" event in pds-lubes-spa-price topic

  Scenario: Happy path for spa price delete
    Given PROS published spa price information from json "pros_spa_price_deleted_input.json" to pds-list-price-condition topic
    When spa price should be mapped with mapping condition correctly and saved in spa_price table successfully 10 seconds later
    Then pds should publish the payload as "pds_spa_price_deleted_output.json" for "CHANGED" event in pds-lubes-spa-price topic
