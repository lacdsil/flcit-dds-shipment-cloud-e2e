package Shipment.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MessagesConstants {

  public static final String MESSAGE_RECEIVED_WITH_SUCCESS = "Received message with Payload: {}, on partition: {} with offset: {}";
  public static final String MESSAGE_PROCESSING_FINISHED_WITH_SUCCESS = "[{}] [{}] [{}] [{}] - Message processing finished: [{}]";
  public static final String MESSAGE_PROCESSING_FINISHED_WITH_FAILURE = "[{}] [{}] [{}] [{}] - Message processing finished with failure: [{}]";
  public static final String MESSAGE_FAILED_TO_CONVERT_FROM_JSON = "Failed to convert received message: {} from json";
  public static final String MESSAGE_MISSING_SOME_FIELD = "Missing fields in received message: ";
  public static final String INVALID_MESSAGE_TYPE = "Invalid message type: ";
  public static final String RESULT_ETA_NULL_ERROR = "[{}] ETA date is Null";
  public static final String ETA_NULL_ERROR = "Delivery [{}] in Shipment [{}] has ETA date Null";
  public static final String RESULT_LOADING_DATE_NULL_ERROR = "[{}] Loading date is Null";
  public static final String LOADING_DATE_NULL_ERROR = "Delivery [{}] in Shipment [{}] has LoadingDate Null";
  public static final String PLANT_CODES_NOT_IN_LIST = "[{}]  Plant codes {} are not in list ({})";
  public static final String GROUP_ID_NULL_ERROR = "[{}] GroupId is Null";

}
