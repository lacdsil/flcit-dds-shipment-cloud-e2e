package Shipment.dto;

import lombok.Getter;

/**
 * The Enum PackageType holds the package types of the orders.
 * <ul>
 * Defined Package types:
 * <li>Pack</li>
 * <li>Bulk</li>
 * </ul>
 */
public enum PackageType {

  PACK("Pack"), BULK("Bulk");

  @Getter
  private String code;

  PackageType(final String code) {
    this.code = code;
  }
}
