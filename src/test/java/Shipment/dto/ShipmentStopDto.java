package Shipment.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class ShipmentStopDto holds the shipment stop details from P44.
 * <ul>
 * DTO holds the below fields:
 * <li>stopNumber</li>
 * <li>appointmentWindow</li>
 * </ul>
 */
@Data
@NoArgsConstructor
public class ShipmentStopDto {

  private Integer stopNumber;

  private DateRangeDto appointmentWindow;
}
