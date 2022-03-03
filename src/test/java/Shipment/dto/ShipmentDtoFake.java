package Shipment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentDtoFake {

  private String action;


  private String number;


  private String source;
  
  private String messageType;

  private String status;

  private String carrierName;


}
