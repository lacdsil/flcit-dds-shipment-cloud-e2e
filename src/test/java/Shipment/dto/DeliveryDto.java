package Shipment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import static Shipment.dto.DateConstants.DATE_FORMAT;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryDto {


  private String action;


  private String deliveryNumber;


  private String source;

  private CustPlantAddrDto plant;

  private CustPlantAddrDto soldTo;

  private CustPlantAddrDto shipTo;

  private String division;

  private String distributionChannel;

  private String salesOrganization;

  private String shippingCondition;

  private String status;

  private String group;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private Date actualGIDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private Date plannedLoadingDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private Date creationDate;

  private ChangedDto changed;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private Date plannedDeliveryDate;

  private String supplyMethod;

  private Double transitTimeDays;

  private List<DeliveryItemsDto> deliveryLineItems;

  private MetadataDto metadata;

  private List<EventDto> events;

  private String orderNumber;

  private String purchaseOrderNumber;

  private String sealNumber;

  private String miscellaneousNumber;

  private String trailerNumber;

  private String incoTerm;

  private String carrierName;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private Date requestedDeliveryDate;

  private String shipmentItemNumber;

  private String carrierSapNumber;

  private String externalShipmentId;

  private String shipmentApiMode;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  private Date etaDate;

  private String logicalOrderNumber;


  private String deliveryType;

  private String specialInstructions;

  private String totalGoodsMovementStatus;

  private String esn;

}
