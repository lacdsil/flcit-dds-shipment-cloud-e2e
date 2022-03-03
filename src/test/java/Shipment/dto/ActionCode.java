package Shipment.dto;

import lombok.Getter;

/**
 * The Enum ActionCode holds the actions defined in the payloads.
 * <ul>
 * Defined Action codes:
 * <li>Create</li>
 * <li>Change</li>
 * <li>Delete</li>
 * </ul>
 */
public enum ActionCode {

  CREATE("Create"), CHANGE("Change"), DELETE("Delete");

  @Getter
  private String code;

  ActionCode(final String code) {
    this.code = code;
  }

}
