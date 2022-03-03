package Shipment.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Delivery entity is a class for holding all the Delivery attributes.
 */
@Data
public class Delivery implements Serializable {

  private static final long serialVersionUID = 1L;

  private MetadataDto metadata;

  private String deliveryId;

  private ActionCode action;

  private String deliveryNumber;

  private String source;

  private String soldTo;

  private String soldToName;

  private String shipTo;

  private String shipToName;

  private Address shipToAddress;

  private String plantCode;

  private Address plantAddress;

  private String salesOrganization;

  private String division;

  private String distributionChannel;

  private String shippingCondition;

  private String status;

  private String groupId;

  private String updatedBy;

  private String esn;

  private String shipmentNumber;

  private ZonedDateTime updatedAt;

  private ZonedDateTime plannedDeliveryDate;

  private ZonedDateTime actualGIDate;

  private ZonedDateTime plannedLoadingDate;

  private ZonedDateTime etaDate;

  private Double transitTimeDays;

  private ZonedDateTime creationDate;

  private ZonedDateTime loadingDateTime;

  private ZonedDateTime holidayApiDateTime;

  private Boolean ignoreTransitTime;

  private SupplyMethod supplyMethod;

  private List<DeliveryItem> deliveryLineItems;

  private List<Event> events;

  private String orderNumber;

  private String purchaseOrderNumber;

  private String sealNumber;

  private String miscellaneousNumber;

  private String trailerNumber;

  private String incoTerm;

  private String carrierName;

  private ZonedDateTime requestedDeliveryDate;

  private String shipmentItemNumber;

  private String carrierSapNumber;

  private String plantName;

  private String externalShipmentId;

  private String shipmentApiMode;

  private String logicalOrderNumber;

  private boolean shouldResend;

  private String customerGroup;

  private String deliveryType;

  private String specialInstructions;

  private String totalGoodsMovementStatus;

}
