package Shipment.dto;

import lombok.Getter;


public enum MessageType {

  YVOSAC_MQ("YVOSAC_MQ"), SHPMNT_MQ("SHPMNT_MQ"), NULL_MESSAGETYPE(null);
  @Getter
  private  String code;

  MessageType(final String code) {
    this.code = code;
  }

}
