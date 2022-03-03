package common;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Slf4j
@NoArgsConstructor
public class KafkaPublisher<T> {

  private KafkaTemplate<Integer, T> kafkaTemplate = kafkaTemplate();

  public void publish(String topic, List<T> events) {
    events.forEach(
        event -> {
          log.info("Publishing {}: {}", event.getClass().getSimpleName(), event);
          try {
            log.info(kafkaTemplate.send(topic, event).get().toString());
          } catch (InterruptedException e) {
            e.printStackTrace();
          } catch (ExecutionException e) {
            e.printStackTrace();
          }
        });
  }

  public KafkaTemplate<Integer, T> kafkaTemplate() {
    return new KafkaTemplate(producerFactory());
  }

  public ProducerFactory<Integer, String> producerFactory() {
    Properties applicationProperties = PropertyFileReader.readApplicationProperties();
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, applicationProperties.getProperty("bootstrap.servers"));
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    props.put("sasl.mechanism", "PLAIN");
    props.put(
        "sasl.jaas.config",
        String.format(
            "org.apache.kafka.common.security.plain.PlainLoginModule "
                + "required username=\"%s\" "
                + "password=\"%s\";",
            System.getProperty("kafka.username"), System.getProperty("kafka.password")));
    props.put("security.protocol", applicationProperties.getProperty("security.protocol"));
    return new DefaultKafkaProducerFactory<>(props);
  }
}
