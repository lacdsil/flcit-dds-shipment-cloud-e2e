package listPrice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConditionTableDataRecordDTO {
  @JsonProperty("UUID")
  private String uuid;

  @JsonProperty("QuoteXID")
  private String quoteId;

  @JsonProperty("Condition_Type")
  private String conditionType;

  @JsonProperty("Condition_Table_ID")
  private String conditionTableId;

  @JsonProperty("Key_Values")
  private String keyValues;

  @JsonProperty("Valid_From_Date")
  private String validFromDate;

  @JsonProperty("Valid_To_Date")
  private String validToDate;

  @JsonProperty("Currency_Code")
  private String currencyCode;

  @JsonProperty("Base_Per_Quantity")
  private String basePerQuantity;

  @JsonProperty("Base_UOM_Code")
  private String baseUOMCode;

  @JsonProperty("Condition_Value")
  private String conditionValue;

  @JsonProperty("Action")
  private String action;

  @JsonProperty("Extraction_Time")
  private String extractionTime;
}
