package Shipment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {

  private String street;

  private String city;

  private String country;

  private String countryRegion;

  private String countryRegionDesc;

  private String postalCode;

}
