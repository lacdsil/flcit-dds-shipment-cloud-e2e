package Shipment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The Class ShipmentItemDto holds all the shipment line items from the Inbound queue message.
 * <ul>
 * DTO holds the below fields:
 * <li>deliveryNumber</li>
 * <li>shipmentItemNumber</li>
 * <li>stopNumber</li>
 * </ul>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipmentItemDto {

  private String deliveryNumber;

  private String shipmentItemNumber;

  private Integer stopNumber;

}
