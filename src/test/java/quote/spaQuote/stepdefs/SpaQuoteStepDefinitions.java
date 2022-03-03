package quote.spaQuote.stepdefs;


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
import quote.spaQuote.dto.SPAQuoteRequestDTO;
import util.ResourceUtils;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;


import static io.cucumber.messages.internal.com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@ContextConfiguration()

public class SpaQuoteStepDefinitions {
    private ObjectMapper MAPPER = new ObjectMapper();

    private Properties applicationProperties = PropertyFileReader.readApplicationProperties();

    @Given("PROS published spa quote information from json {string} to pros-quote topic")
    public void prosPublishedSpaQuoteInformationFromJsonToProsQuoteTopic(String fileName) throws JsonProcessingException {
        KafkaPublisher kafkaPublisher = new KafkaPublisher();

        String prosSpaQuoteInput = ResourceUtils.readFile("spaQuote", fileName);
        log.info(prosSpaQuoteInput);
        SPAQuoteRequestDTO spaQuoteRequestDTO = MAPPER.readValue(prosSpaQuoteInput, SPAQuoteRequestDTO.class);
        kafkaPublisher.publish(applicationProperties.getProperty("kafka.produce-topics.pros-quote"), newArrayList(spaQuoteRequestDTO));
    }

    @When("spa quote should be mapped with mapping condition correctly and saved in quote table successfully {int} seconds later")
    public void spaQuoteShouldBeMappedWithMappingConditionCorrectlyAndSavedInQuoteTableSuccessfullySecondsLater(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    @Then("pds should publish the payload as {string} for {string} event in pds-lubes-spa-quote topic")
    public void pdsShouldPublishThePayloadAsForEventInPdsLubesSpaQuoteTopic(String fileName, String action) throws JsonProcessingException {
        String actualResult = new KafkaConsumerRecord(applicationProperties.getProperty("kafka.consumer-topics.pds-lubes-spa-quote"))
                .poll(30).stream()
                .filter(event -> event.contains("E2E"))
                .map(s -> RegexUtils.removeIncompareFields(s))
                .collect(Collectors.joining(","));

        log.info("Actual:\n{}",actualResult);


        String excepted = ResourceUtils.readFile("spaQuote", fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        String exceptedMinify = objectMapper.readValue(excepted, JsonNode.class).toString();
        String exceptedResult = RegexUtils.removeIncompareFields(exceptedMinify);
        exceptedResult = StringUtils.strip(exceptedResult,"[]");
        log.info("Excepted:\n{}",exceptedResult);

        assertEquals(exceptedResult,actualResult);
    }

    @Then("pds should not publish any message to pds-lubes-spa-quote topic")
    public void pdsShouldNotPublishAnyMessageToPdsLubesSpaQuoteTopic() {
        List<String> actual = new KafkaConsumerRecord(applicationProperties.getProperty("kafka.consumer-topics.pds-lubes-spa-quote"))
                .poll(30).stream()
                .filter(event -> event.contains("E2E"))
                .collect(Collectors.toList());

        assertEquals(true,actual.isEmpty()) ;
    }
}
