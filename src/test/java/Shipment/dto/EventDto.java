package Shipment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

import static Shipment.dto.DateConstants.DATE_FORMAT;

@Data
public class EventDto {

  private String eventid;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private Date timestamp;

}
