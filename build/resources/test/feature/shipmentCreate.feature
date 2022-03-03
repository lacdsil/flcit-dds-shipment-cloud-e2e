@shipmentCreate
Feature: Publish Shipment
  Scenario: Happy path for Shipment creation
    Given  dds OnPrem published shipment information from json "shipment-inbound-with-deliveries.json" to shipmentInternal-qa topic
    When shipment should be mapped with mapping condition correctly 10 seconds later
    Then shipment should publish the payload as "shipment_dto_19914521_full.json" event in shipment-qa topic

