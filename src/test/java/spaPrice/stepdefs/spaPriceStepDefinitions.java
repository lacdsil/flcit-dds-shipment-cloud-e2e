package spaPrice.stepdefs;

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
import listPrice.dto.ConditionTableDataRecordDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.test.context.ContextConfiguration;
import util.ResourceUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import static io.cucumber.messages.internal.com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@ContextConfiguration()
public class spaPriceStepDefinitions {

    private ObjectMapper MAPPER = new ObjectMapper();

    private Properties applicationProperties = PropertyFileReader.readApplicationProperties();

    @Given("PROS published spa price information from json {string} to pds-list-price-condition topic")
    public void prosPublishedSpaPriceInformationFromJsonToPdsListPriceConditionTopic(String fileName) throws JsonProcessingException {
        KafkaPublisher kafkaPublisher = new KafkaPublisher();

        String spaPriceInput = ResourceUtils.readFile("spaPrice", fileName);
        log.info(spaPriceInput);
        ConditionTableDataRecordDTO conditionTableDataRecordDTO = MAPPER.readValue(spaPriceInput, ConditionTableDataRecordDTO.class);
        kafkaPublisher.publish(applicationProperties.getProperty("kafka.produce-topics.pros-price-condition"), newArrayList(conditionTableDataRecordDTO));
    }

    @When("spa price should be mapped with mapping condition correctly and saved in spa_price table successfully {int} seconds later")
    public void spaPriceShouldBeMappedWithMappingConditionCorrectlyAndSavedInSpa_priceTableSuccessfullySecondsLater(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    @Then("pds should publish the payload as {string} for {string} event in pds-lubes-spa-price topic")
    public void pdsShouldPublishThePayloadAsForEventInPdsTopic(String fileName, String action) throws JsonProcessingException {
        String actualResult = new KafkaConsumerRecord(applicationProperties.getProperty("kafka.consumer-topics.pds-lubes-spa-price"))
                .poll(30)
                .stream()
                .filter(event -> event.contains("E2E"))
                .map(s -> RegexUtils.removeIncompareFields(s))
                .sorted(Comparator.comparing(s -> RegexUtils.getStartDate(s)))
                .collect(Collectors.joining(","));

        log.info("Actual:\n{}",actualResult);

        String excepted = ResourceUtils.readFile("spaPrice", fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        String exceptedMinify = objectMapper.readValue(excepted, JsonNode.class).toString();
        String exceptedResult = RegexUtils.removeIncompareFields(exceptedMinify);
        exceptedResult = StringUtils.strip(exceptedResult,"[]");
        log.info("Excepted:\n{}",exceptedResult);

        assertEquals(exceptedResult,actualResult);
    }
}
