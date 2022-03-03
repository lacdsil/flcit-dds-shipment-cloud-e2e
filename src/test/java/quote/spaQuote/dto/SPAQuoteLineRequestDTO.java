package quote.spaQuote.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import quote.dto.consume.QuotePriceRequestDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class SPAQuoteLineRequestDTO {

  @JsonProperty("shortPartNumberColumn")
  private String product;

  @JsonProperty("sellAsProductCol")
  private SPASellAsProductColDTO spaSellAsProductColDto;

  @JsonProperty("spaDiscountColumn")
  private QuotePriceRequestDTO spaDiscountColumn;

  @JsonProperty("spaPriceColumn")
  private QuotePriceRequestDTO spaPriceColumn;

  @JsonProperty("distributorNetPriceColumn")
  private QuotePriceRequestDTO distributorNetPriceColumn;

  @JsonProperty("shippingCondition")
  private String shippingCondition;

  @JsonProperty("requiredVolForMarginMatch")
  private String requiredVolForMarginMatch;

  @JsonProperty("additionalVolNeededPercent")
  private String additionalVolNeededPercent;

  @JsonProperty("rebateProgram1")
  private String rebateProgram1;

  @JsonProperty("additionalVolNeeded")
  private String additionalVolNeeded;

  @JsonProperty("rebateValue4")
  private QuotePriceRequestDTO rebateValue4;

  @JsonProperty("rebateProgram2")
  private String rebateProgram2;

  @JsonProperty("unitDeliveredMarginCol")
  private QuotePriceRequestDTO unitDeliveredMargin;

  @JsonProperty("publishAccountIdColumn")
  private String publishAccountIdColumn;

  @JsonProperty("rebateProgram5")
  private String rebateProgram5;

  @JsonProperty("currentQuantityColumn")
  private String estimated12MonthVolume;

  @JsonProperty("referenceCostColumn")
  private QuotePriceRequestDTO referenceCost;

  @JsonProperty("rebateValue3")
  private QuotePriceRequestDTO rebateValue3;

  @JsonProperty("competitorPriceColumn")
  private QuotePriceRequestDTO competitorPrice;

  @JsonProperty("rebateProgram3")
  private String rebateProgram3;

  @JsonProperty("rebateValue2")
  private QuotePriceRequestDTO rebateValue2;

  @JsonProperty("floorColumn")
  private QuotePriceRequestDTO floorPrice;

  @JsonProperty("unitGrossMarginCol")
  private QuotePriceRequestDTO unitGrossMargin;

  @JsonProperty("expertColumn")
  private QuotePriceRequestDTO expertPrice;

  @JsonProperty("rebateProgram4")
  private String rebateProgram4;

  @JsonProperty("exportUomColumn")
  private String uom;

  @JsonProperty("pocketPriceColumn")
  private QuotePriceRequestDTO pocketPrice;

  @JsonProperty("rebateValue1")
  private QuotePriceRequestDTO rebateValue1;

  @JsonProperty("earlyPaymentDiscountColumn")
  private QuotePriceRequestDTO earlyPaymentDiscount;

  @JsonProperty("rebateValue5")
  private QuotePriceRequestDTO rebateValue5;

  @JsonProperty("costConverted")
  private QuotePriceRequestDTO unitCost;

  @JsonProperty("targetColumn")
  private QuotePriceRequestDTO targetPrice;

  @JsonProperty("apf_maxColumn")
  private String apfMaxThreshold;

  @JsonProperty("apf_minColumn")
  private String apfMinThreshold;

  @JsonProperty("apfScoreColumn")
  private String apfScore;

  @JsonProperty("apt_bottomColumn")
  private String aptMinThreshold;

  @JsonProperty("apt_topColumn")
  private String aptMaxThreshold;

  @JsonProperty("aptScoreColumn")
  private String aptScore;

  @JsonProperty("deliveredMarginUoMCol")
  private QuotePriceRequestDTO deliveredMargin;

  @JsonProperty("drivingFactorCol")
  private String drivingFactor;

  @JsonProperty("margin_bottomColumn")
  private String marginMinThreshold;

  @JsonProperty("margin_topColumn")
  private String marginMaxThreshold;

  @JsonProperty("marginScoreColumn")
  private String marginScore;

  @JsonProperty("premiumColumn")
  private String premiumIndicator;

  @JsonProperty("productFamilyColumn")
  private String productFamily;

  @JsonProperty("wtProductPriceColumn")
  private QuotePriceRequestDTO productPrice;

  @JsonProperty("productTypeColumn")
  private String productType;

  @JsonProperty("rolling12MoQtyColumn")
  private String rolling12monthQty;

  @JsonProperty("totalRebatesColumn")
  private QuotePriceRequestDTO itemMFAPS;

  @JsonProperty("traderMarginCol")
  private QuotePriceRequestDTO traderMargin;

  @JsonProperty("uomWaterfallCol")
  private String uomWaterfall;

  @JsonProperty("wtDeliverySurcharge")
  private QuotePriceRequestDTO deliverySurcharge;

  @JsonProperty("wtEarlyPaymentDiscountColumn")
  private QuotePriceRequestDTO totalEarlyPaymentDiscount;

  @JsonProperty("wtFreightColumn")
  private QuotePriceRequestDTO freightPrice;

  @JsonProperty("wtGrossMarginL15Col")
  private QuotePriceRequestDTO grossMarginL15;

  @JsonProperty("wtProductionExpenseCol")
  private QuotePriceRequestDTO productionExpense;
}
