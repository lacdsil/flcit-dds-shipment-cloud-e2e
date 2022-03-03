package CustomerProductCatalog.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProductCatalogMetadataDTO {

  @JsonProperty("eventId")
  private String eventId;

  @JsonProperty("eventType")
  private String eventType;

  @JsonProperty("timestamp")
  private String timestamp;
}
