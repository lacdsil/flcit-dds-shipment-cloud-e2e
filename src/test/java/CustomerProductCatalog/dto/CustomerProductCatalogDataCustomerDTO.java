package CustomerProductCatalog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProductCatalogDataCustomerDTO {

  @JsonProperty("id")
  private String id;

  @JsonProperty("number")
  private String number;

  @JsonProperty("accountType")
  private String type;

}
