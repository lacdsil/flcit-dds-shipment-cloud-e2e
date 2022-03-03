@listPrice
Feature: List Price
  Scenario: Happy path for list price creation
    Given PROS published list price information from json "pros_list_price_created_input.json" to pds-list-price-condition topic
    When List price should be mapped with mapping condition correctly and saved in list_price table successfully 10 seconds later
    Then pds should publish the payload as "list_price_created_output.json" for "CREATED" event in pds-list-price topic

  Scenario: Happy path for list price update
    Given PROS published list price information from json "pros_list_price_changed_input.json" to pds-list-price-condition topic
    When List price should be mapped with mapping condition correctly and saved in list_price table successfully 10 seconds later
    Then pds should publish the payload as "list_price_changed_output.json" for "CHANGED" event in pds-list-price topic

  Scenario: Happy path for list price delete
    Given PROS published list price information from json "pros_list_price_update_input_delete.json" to pds-list-price-condition topic
    When List price should be mapped with mapping condition correctly and saved in list_price table successfully 10 seconds later
    Then pds should publish the payload as "list_price_update_output_delete.json" for "CHANGED" event in pds-list-price topic
