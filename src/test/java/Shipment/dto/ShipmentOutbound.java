package Shipment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static Shipment.dto.DateConstants.DATE_FORMAT;
import static Shipment.dto.DateConstants.SIMPLE_DATE_FORMAT;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentOutbound {

  private MetadataDto metadata;

  private String action;

  private String groupId;

  private String soldTo;

  private String shipTo;

  private String groupStatus;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = SIMPLE_DATE_FORMAT)
  private Date groupEta;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private Date loadingDate;

  private String packageType;

  private List<DeliveryDto> deliveries;

  private Set<String> deliveryNumbers;

  private String vehicleIdentifier;

  private Integer stopNumber;

  private String transportationStatus;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private String actualLoadDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private String actualDeliveryDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private Date goodsInspectionDate;

  private ChangedDto changed;

  private String status;

  private String statusDescription;

  public static final ObjectMapper objectMapper = new ObjectMapper();

  @SneakyThrows
  public String toString() {
    return objectMapper.writeValueAsString(this);
  }

}
