package Shipment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static Shipment.dto.DateConstants.DATE_FORMAT;

/**
 * The Class ShipmentArrivalEstimateDto holds the Shipment arrival dates from P44.
 * <ul>
 * DTO holds the below fields:
 * <li>lastCalculatedDateTime</li>
 * <li>estimatedArrivalWindow</li>
 * </ul>
 */
@Data
@NoArgsConstructor
public class ShipmentArrivalEstimateDto {

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private Date lastCalculatedDateTime;

  private DateRangeDto estimatedArrivalWindow;

}
