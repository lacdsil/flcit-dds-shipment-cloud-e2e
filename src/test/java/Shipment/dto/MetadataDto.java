package Shipment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static Shipment.dto.DateConstants.DATE_FORMAT;

/**
 * The Class MetadataDto holds the meta data details from the Input queue messages.
 * <ul>
 * DTO holds the below fields:
 * <li>updatedAt</li>
 * <li>updatedBy</li>
 * <li>middleware</li>
 * <li>middlewareReference</li>
 * </ul>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MetadataDto {

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private Date updatedAt;


  private String updatedBy;


  private String middleware;


  private String middlewareReference;

  private String messageType;
}
