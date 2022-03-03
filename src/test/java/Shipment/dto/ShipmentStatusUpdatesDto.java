package Shipment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentStatusUpdatesDto {

  private Date timestamp;

  private int stopNumber;

  private StatusDto statusReason;
}
