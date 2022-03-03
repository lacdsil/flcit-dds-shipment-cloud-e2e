package Shipment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentInbound {


  private ShipmentDto shipmentDto;

  private List<Delivery> deliveries;

  private String status;


}
