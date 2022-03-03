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
public class ShipmentDto {

  private MetadataDto metadata;


  private String action;


  private String number;


  private String source;
  
  private String messageType;

  private String messageTypeValid;

  private String messageTypePresent;

  private List<ShipmentItemDto> deliveries;

  private String status;

  private String carrierName;

  private String vehicleIdentifier;

  private String carrierSapNumber;

  private String externalShipmentId;

  private String shipmentApiMode;

  private IdentifierDto carrierIdentifier;

  private String plannedLoadingDate;

  private String functionalStatus;

  private String functionalStatusDescription;

  private List<IdentifierDto> shipmentIdentifiers;

  private List<IdentifierDto> equipmentIdentifiers;

  private List<ShipmentStopDto> shipmentStops;

  private List<ShipmentStatusUpdatesDto> statusUpdates;

  private List<ShipmentStopStatusDto> latestStopStatuses;

  private String groupId;

}
