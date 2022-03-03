package Shipment.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class TypeValueDto holds the type and the corresponding value attributes.
 * <ul>
 * DTO holds the below fields:
 * <li>type</li>
 * <li>value</li>
 * </ul>
 */
@Data
@NoArgsConstructor
public class IdentifierDto {

  private String type;

  private String value;
}
