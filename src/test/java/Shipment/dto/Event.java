package Shipment.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * Event entity is a class for holding all the 3rd party system Events attributes.
 * <ul>
 * Entity has the below fields:
 * <li>id</li>
 * <li>eventId</li>
 * <li>timestamp</li>
 * <li>deliveryId</li>
 * </ul>
 */
@Data
public class Event implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String eventId;

  private ZonedDateTime timestamp;

  private String deliveryId;

  @ToString.Exclude
  private Delivery delivery;
}
