@shipmentCreateFake
Feature: Publish Shipment Fake
  Scenario: Happy path for Shipment creation
    Given  dds OnPrem published fake shipment information from json "shipment_dto_19914521.json" to shipmentInternal-qa topic
    When fake shipment should be mapped with mapping condition correctly 10 seconds later
    Then fake shipment should publish the payload as "shipment_dto_19914521.json" event in shipment-qa topic

