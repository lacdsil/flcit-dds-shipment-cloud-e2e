package Shipment.dto;

import lombok.Data;

@Data
public class DeliveryItemsDto {

  private String itemNumber;

  private String material;

  private Double quantity;

  private String uom;

  private String packageType;

  private String materialDescription;

  private Double palletCount;

  private Double volumeQuantity;

  private String volumeUom;

  private String orderItemNumber;

  private Double goodsInspectionDeltaQty;

  private String grossUom;

  private String grossWeight;

}
