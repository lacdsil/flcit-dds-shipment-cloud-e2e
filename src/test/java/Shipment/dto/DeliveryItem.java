package Shipment.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * DeliveryItem entity is a class for holding all the Delivery Line Items attributes.
 */
@Data
@Builder
public class DeliveryItem implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String itemNumber;

  private String material;

  private Double quantity;

  private String uom;

  private PackageType packageType;

  private String materialDescription;

  private Double palletCount;

  private Double volumeQuantity;

  private String volumeUom;

  private String orderItemNumber;

  private Double goodsInspectionDeltaQty;

  private String grossUoM;

  private String grossWeight;

}
