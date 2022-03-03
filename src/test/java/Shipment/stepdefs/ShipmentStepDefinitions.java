package Shipment.stepdefs;

import Shipment.dto.ShipmentInbound;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.KafkaConsumerRecord;
import common.KafkaPublisher;
import common.PropertyFileReader;
import common.RegexUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.test.context.ContextConfiguration;
import util.ResourceUtils;

import java.util.Properties;
import java.util.stream.Collectors;

import static io.cucumber.messages.internal.com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@ContextConfiguration()
public class ShipmentStepDefinitions {
    ObjectMapper MAPPER = new ObjectMapper();

    private Properties applicationProperties = PropertyFileReader.readApplicationProperties();
    @Given("dds OnPrem published shipment information from json {string} to shipmentInternal-qa topic")
    public void ddsOnPremPublishedShipmentInformationToShipmentInternalQaTopic(String fileName) throws JsonProcessingException {
        KafkaPublisher kafkaPublisher = new KafkaPublisher();
        String ShipmentInput = ResourceUtils.readFile("shipmentCreate", fileName);
        log.info(ShipmentInput);
        ShipmentInbound shipmentInbound = MAPPER.readValue(ShipmentInput, ShipmentInbound.class);
        kafkaPublisher.publish(applicationProperties.getProperty("kafka.producer-topics.shipmentInternal"), newArrayList(shipmentInbound));
    }

    @When("shipment should be mapped with mapping condition correctly {long} seconds later")
    public void shipmentShouldBeMappedWithMappingConditionCorrectlySecondsLater(long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    @Then("shipment should publish the payload as {string} event in shipment-qa topic")
    public void ddsShouldPublishThePayloadAsForEventShipmentQaTopic(String fileName) throws JsonProcessingException {
        String actualResult = new KafkaConsumerRecord(applicationProperties.getProperty("kafka.consumer-topics.shipmentInternal"))
                .poll(30).stream()
                .filter(event -> event.contains("Create"))
                .map(s -> RegexUtils.removeIncompareFields(s))
                .collect(Collectors.joining(","));

        log.info("Actual:\n{}",actualResult);


        String excepted = ResourceUtils.readFile("shipmentCreate", fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        String exceptedMinify = objectMapper.readValue(excepted, JsonNode.class).toString();
        String exceptedResult = RegexUtils.removeIncompareFields(exceptedMinify);
        exceptedResult = StringUtils.strip(exceptedResult,"[]");
        log.info("Excepted:\n{}",exceptedResult);

        assertEquals(exceptedResult,actualResult);
    }
}
