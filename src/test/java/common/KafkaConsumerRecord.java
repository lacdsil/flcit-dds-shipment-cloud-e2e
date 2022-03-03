package common;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class KafkaConsumerRecord {

  private final String topic;

  public KafkaConsumerRecord(String topic) {
    this.topic = topic;
  }

  public List<String> poll(long seconds) {

    List<String> records = new ArrayList<>();
    KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(getProperties());
    kafkaConsumer.subscribe(Collections.singletonList(topic));

    try {
      long endPollingTimestamp = System.currentTimeMillis() + seconds * 1000;
      System.out.println(String.format("Polling... %s for %s second(s)", topic, seconds));
      while (System.currentTimeMillis() < endPollingTimestamp) {
        ConsumerRecords<String, String> consumerRecords =
            kafkaConsumer.poll(Duration.of(1, ChronoUnit.SECONDS));
        for (ConsumerRecord<String, String> next : consumerRecords) {
          System.out.println(next.value());
          records.add(next.value());
        }
      }
    } finally {
      kafkaConsumer.close();
    }
    return records;
  }

  private Properties getProperties() {
    Properties applicationProperties = PropertyFileReader.readApplicationProperties();
    Properties kafkaProperties = PropertyFileReader.read("kafka.properties");

    kafkaProperties.setProperty(
        "bootstrap.servers", applicationProperties.getProperty("bootstrap.servers"));
    kafkaProperties.setProperty(
        "sasl.jaas.config",
        String.format(
            "org.apache.kafka.common.security.plain.PlainLoginModule "
                + "required username=\"%s\" "
                + "password=\"%s\";",
            System.getProperty("kafka.username"), System.getProperty("kafka.password")));

    return kafkaProperties;
  }
}
