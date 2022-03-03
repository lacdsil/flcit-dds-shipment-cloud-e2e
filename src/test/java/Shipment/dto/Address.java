package Shipment.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Address entity is a class for holding all the customer plant, ship To, sold To addresses.
 * <ul>
 * Entity has the below fields:
 * <li>addressId</li>
 * <li>street</li>
 * <li>city</li>
 * <li>country</li>
 * <li>countryRegion</li>
 * <li>countryRegionDesc</li>
 * <li>postalCode</li>
 * </ul>
 */
@Data
public class Address implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long addressId;

  private String street;

  private String city;

  private String country;

  private String countryRegion;

  private String countryRegionDesc;

  private String postalCode;

}
