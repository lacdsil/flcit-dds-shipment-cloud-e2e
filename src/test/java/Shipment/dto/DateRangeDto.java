package Shipment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import static Shipment.dto.DateConstants.DATE_FORMAT;

/**
 * The Class DateRangeDto is a generic dto to hold the start and end dates.
 * <ul>
 * DTO holds the below fields:
 * <li>startDateTime</li>
 * <li>endDateTime</li>
 * </ul>
 */
@Data
@NoArgsConstructor
public class DateRangeDto {

  @DateTimeFormat(pattern = DATE_FORMAT)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private Date startDateTime;

  @DateTimeFormat(pattern = DATE_FORMAT)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private Date endDateTime;
}
