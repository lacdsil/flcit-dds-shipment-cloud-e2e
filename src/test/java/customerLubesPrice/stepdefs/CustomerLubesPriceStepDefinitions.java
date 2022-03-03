package customerLubesPrice.stepdefs;

import com.fasterxml.jackson.databind.JsonNode;
import common.RegexUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.KafkaConsumerRecord;
import common.KafkaPublisher;
import common.PropertyFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.AssertionFailedError;
import listPrice.dto.ConditionTableDataRecordDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.test.context.ContextConfiguration;
import util.ResourceUtils;
import CustomerProductCatalog.dto.CustomerProductCatalogDTO;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

import static io.cucumber.messages.internal.com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Slf4j
@ContextConfiguration()

public class CustomerLubesPriceStepDefinitions {

    private ObjectMapper MAPPER = new ObjectMapper();
    private Properties applicationProperties = PropertyFileReader.readApplicationProperties();

    @Given("PROS published list price from json {string} to pds-list-price-condition topic")
    public void prosPublishedListPriceFromJsonToPdsListPriceConditionTopic(String fileName) throws IOException {
        KafkaPublisher kafkaPublisher = new KafkaPublisher();

        String prosPriceConditionInput = ResourceUtils.readFile("customerLubesPrice", fileName);
        log.info(prosPriceConditionInput);
        ConditionTableDataRecordDTO conditionTableDataRecordDTO = MAPPER.readValue(prosPriceConditionInput, ConditionTableDataRecordDTO.class);
        kafkaPublisher.publish(applicationProperties.getProperty("kafka.produce-topics.pros-price-condition"), newArrayList(conditionTableDataRecordDTO));
    }

    @And("PROS published customer product catalog from json {string} to customer-product-catalog topic")
    public void prosPublishedCustomerProductCatalogFromJsonToCustomerProductCatalogTopic(String fileName) throws IOException{
        KafkaPublisher kafkaPublisher = new KafkaPublisher();

        String customerProductCatalog = ResourceUtils.readFile("customerLubesPrice", fileName);
        log.info(customerProductCatalog);
        CustomerProductCatalogDTO customerProductCatalogDTO = MAPPER.readValue(customerProductCatalog, CustomerProductCatalogDTO.class);
        kafkaPublisher.publish(applicationProperties.getProperty("kafka.producer-topics.pros-customer-product-catalog"),newArrayList(customerProductCatalogDTO));
    }

    @When("CLP should be mapped with mapping condition correctly and saved in clp table successfully {long} seconds later")
    public void  waitForMapConditionCorrectlyAndSaveInListPriceTableSuccessfully(long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    @Then("pds should publish the payload as {string} for {string} event in pds-customer-lubes-price topic")
    public void pdsShouldPublishThePayloadAsForEventInPdsCustomerLubesPriceTopic(String fileName, String action) throws JsonProcessingException {
        String actualResult = new KafkaConsumerRecord(applicationProperties.getProperty("kafka.consumer-topics.pds-customer-lubes-price"))
                .poll(30).stream()
                .filter(event -> event.contains("E2E"))
                .map(s -> RegexUtils.removeIncompareFields(s))
                .sorted(Comparator.comparing(s -> RegexUtils.getStartDate(s)))
                .collect(Collectors.joining(","));

        log.info("Actual:\n{}",actualResult);

        String excepted = ResourceUtils.readFile("customerLubesPrice", fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        String exceptedMinify = objectMapper.readValue(excepted, JsonNode.class).toString();
        String exceptedResult = RegexUtils.removeIncompareFields(exceptedMinify);
        exceptedResult = StringUtils.strip(exceptedResult,"[]");
        log.info("Excepted:\n{}",exceptedResult);

        assertEquals(exceptedResult,actualResult);
    }

    @Then("pds should publish the payload as {string} in pds-customer-lubes-price topic")
    public void pdsShouldPublishThePayloadAsAndInPdsCustomerLubesPriceTopic(String fileName) throws JsonProcessingException {
       String actualResult = new KafkaConsumerRecord(applicationProperties.getProperty("kafka.consumer-topics.pds-customer-lubes-price"))
                .poll(30).stream()
                .filter(event -> event.contains("E2E"))
                .map(s -> RegexUtils.removeIncompareFields(s))
                .sorted(Comparator.comparing(s -> RegexUtils.getStartDate(s)))
                .collect(Collectors.joining(","));

        log.info("Actual:\n{}",actualResult);

        String excepted = ResourceUtils.readFile("customerLubesPrice", fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        String exceptedMinify = objectMapper.readValue(excepted, JsonNode.class).toString();
        String exceptedResult = RegexUtils.removeIncompareFields(exceptedMinify);
        exceptedResult = StringUtils.strip(exceptedResult,"[]");
        log.info("Excepted:\n{}",exceptedResult);

        assertEquals(exceptedResult,actualResult);
    }

    @And("call customer lubes api will return {string}")
    public void callCustomerLubesApiWillReturn(String fileName) throws JsonProcessingException {
        String baseUrl = applicationProperties.getProperty("baseUrl");
        String excepted = ResourceUtils.readFile("customerLubesPrice", fileName);

        Response response = RestAssured.given()
                .auth()
                .oauth2(getToken())
                .param("stripesSystem","NA")
                .param("accountNumber","120666")
                .param("productNumber","106076")
                .when()
                .get(baseUrl+"/v1/customer-lubes-price")
                .then()
                .statusCode(200)
                .extract().response();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actual = mapper.readTree(response.asPrettyString());
        JsonNode exceptedResult = mapper.readTree(excepted);
        assertEquals(exceptedResult,actual);
    }

    private String getToken(){
        String clientId = Optional.ofNullable(applicationProperties.getProperty("clientId"))
            .orElseThrow(() -> new AssertionFailedError("Cannot find 'clientId'"));
        String clientSecret = Optional.ofNullable(System.getProperty("clientSecret"))
            .orElseThrow(() -> new AssertionFailedError("Cannot find 'clientSecret'"));
        String resource = Optional.ofNullable(applicationProperties.getProperty("resource"))
                .orElseThrow(() -> new AssertionFailedError("Cannot find 'resource'"));
        String grant_type = Optional.ofNullable(applicationProperties.getProperty("grant_type"))
                .orElseThrow(() -> new AssertionFailedError("Cannot find 'grant_type'"));
        String accessToken = RestAssured.given()
                .param("client_id",clientId)
                .param("client_secret",clientSecret)
                .param("resource",resource)
                .param("grant_type",grant_type)
                .when()
                .post("https://login.microsoftonline.com/d1ee1acd-bc7a-4bc4-a787-938c49a83906/oauth2/token")
                .then()
                .statusCode(200)
                .extract()
                .path("access_token");
        return accessToken;
    }
}