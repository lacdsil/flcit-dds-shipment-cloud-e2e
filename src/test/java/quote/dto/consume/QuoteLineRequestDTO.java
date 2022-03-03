package quote.dto.consume;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteLineRequestDTO {

  @JsonProperty("currentQuantityColumn")
  private BigDecimal estimated12MonthVolume;

  private QuotePriceRequestDTO rebateValue4;

  @JsonProperty("shortPartNumberColumn")
  private String product;

  private String rebateProgram2;

  @JsonProperty("unitDeliveredMarginCol")
  private QuotePriceRequestDTO unitDeliveredMargin;

  private String publishAccountIdColumn;

  private String rebateProgram1;

  private QuotePriceRequestDTO rebateValue3;

  private String rebateProgram5;

  @JsonProperty("wtDeliverySurcharge")
  private QuotePriceRequestDTO deliverySurcharge;

  @JsonProperty("competitorNameColumn")
  private String competitorName;

  private String rebateProgram3;

  @JsonProperty("referenceCostColumn")
  private QuotePriceRequestDTO referenceCost;

  @JsonProperty("floorColumn")
  private QuotePriceRequestDTO floorPrice;

  @JsonProperty("competitorPriceColumn")
  private QuotePriceRequestDTO competitorPrice;

  private QuotePriceRequestDTO rebateValue2;

  @JsonProperty("expertColumn")
  private QuotePriceRequestDTO expertPrice;

  @JsonProperty("inputUomColumn")
  private String specificUom;

  @JsonProperty("unitGrossMarginCol")
  private QuotePriceRequestDTO unitGrossMargin;

  private String rebateProgram4;

  @JsonProperty("productPriceColumn")
  private QuotePriceRequestDTO productPrice;

  private QuotePriceRequestDTO rebateValue1;

  @JsonProperty("exportUomColumn")
  private String uom;

  @JsonProperty("netPriceColumn")
  private QuotePriceRequestDTO netPrice;

  @JsonProperty("hardFloorColumn")
  private QuotePriceRequestDTO hardFloor;

  @JsonProperty("earlyPaymentDiscountColumn")
  private QuotePriceRequestDTO earlyPaymentDiscount;

  @JsonProperty("listColumn")
  private QuotePriceRequestDTO listPrice;

  private QuotePriceRequestDTO rebateValue5;

  @JsonProperty("pocketPriceColumn")
  private QuotePriceRequestDTO pocketPrice;

  @JsonProperty("targetColumn")
  private QuotePriceRequestDTO targetPrice;

  @JsonProperty("costConverted")
  private QuotePriceRequestDTO unitCost;

  @JsonProperty("apf_maxColumn")
  private String apfMaxThreshold;

  @JsonProperty("apf_minColumn")
  private String apfMinThreshold;

  @JsonProperty("apfScoreColumn")
  private String apfScore;

  @JsonProperty("apt_topColumn")
  private String aptMaxThreshold;

  @JsonProperty("apt_bottomColumn")
  private String aptMinThreshold;

  @JsonProperty("aptScoreColumn")
  private String aptScore;

  @JsonProperty("deliveredMarginUoMCol")
  private QuotePriceRequestDTO deliveredMargin;

  @JsonProperty("drivingFactorCol")
  private String drivingFactor;

  @JsonProperty("wtFreightColumn")
  private QuotePriceRequestDTO freightPrice;

  @JsonProperty("wtGrossMarginL15Col")
  private QuotePriceRequestDTO grossMarginL15;

  private QuotePriceRequestDTO invoiceFreight;

  @JsonProperty("totalRebatesColumn")
  private QuotePriceRequestDTO itemMFAPS;

  @JsonProperty("margin_topColumn")
  private String marginMaxThreshold;

  @JsonProperty("margin_bottomColumn")
  private String marginMinThreshold;

  @JsonProperty("marginScoreColumn")
  private String marginScore;

  @JsonProperty("premiumColumn")
  private String premiumIndicator;

  @JsonProperty("productFamilyColumn")
  private String productFamily;

  @JsonProperty("productTypeColumn")
  private String productType;

  @JsonProperty("wtProductionExpenseCol")
  private QuotePriceRequestDTO productionExpense;

  @JsonProperty("rolling12MoQtyColumn")
  private String rolling12monthQty;

  @JsonProperty("wtEarlyPaymentDiscountColumn")
  private QuotePriceRequestDTO totalEarlyPaymentDiscount;

  @JsonProperty("traderMarginCol")
  private QuotePriceRequestDTO traderMargin;

  @JsonProperty("uomWaterfallCol")
  private String uomWaterfall;

  private String shippingCondition;

  @JsonProperty("requiredVolForMarginMatch")
  private String totalVolNeeded;

}
