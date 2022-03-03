package CustomerProductCatalog.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerProductCatalogDTO {

  @JsonProperty("metadata")
  private CustomerProductCatalogMetadataDTO metaData;

  @JsonProperty("data")
  private CustomerProductCatalogDataDTO data;

}
