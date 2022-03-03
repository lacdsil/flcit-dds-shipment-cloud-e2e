package Shipment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static Shipment.dto.DateConstants.DATE_FORMAT;

@Data
@NoArgsConstructor
public class ShipmentStopStatusDto {

  private int stopNumber;

  private String statusCode;

  private ShipmentArrivalEstimateDto arrivalEstimate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private Date arrivalDateTime;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private Date departureDateTime;
}
