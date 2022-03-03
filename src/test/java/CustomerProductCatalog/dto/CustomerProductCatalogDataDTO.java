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
public class CustomerProductCatalogDataDTO {

  @JsonProperty("stripesSystem")
  private String stripesSystem;

  @JsonProperty("customer")
  private CustomerProductCatalogDataCustomerDTO customer;

  @JsonProperty("product")
  private CustomerProductCatalogDataProductDTO product;

  @JsonProperty("priceBookIndicator")
  private String priceBookIndicator;

  @JsonProperty("validFrom")
  private String startDate;

  @JsonProperty("validTo")
  private String endDate;
}
