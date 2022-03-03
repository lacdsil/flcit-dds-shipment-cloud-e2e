package quote.dto.consume;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteHeaderRequestDTO {

  private String priceBookIndicator;

  @JsonProperty("PROSAgreement__Agreement_Id")
  private String agreementId;

  @JsonProperty("PROSAgreement__StartDate")
  private String agreementStartDate;

  @JsonProperty("salesOrgCode")
  private String salesOrg;

  @JsonProperty("displayCurrency")
  private String currency;

  @JsonProperty("PROSAgreement__EndDate")
  private String agreementEndDate;

  @JsonProperty("firmPricingEndDateStrField")
  private String firmPricingEndDate;

  private Boolean firmPricing;

  private String quoteId;

  private Boolean priceProtection;

  @JsonProperty("ppNumberDays")
  private String priceProtectionNumberDays;

  @JsonProperty("isFormulaPricing")
  private Boolean formulaPricing;

  @JsonProperty("quoteTypeField")
  private String quoteType;

  private String legacyQuoteId;

  @JsonProperty("quote_Score_Percentage")
  private String quoteScore;

  @JsonProperty("aggProductPriceField")
  private QuotePriceRequestDTO agreementProductPrice;

  @JsonProperty("apf_weight")
  private String apfWeight;

  @JsonProperty("apt_weight")
  private String aptWeight;

  @JsonProperty("REV_DOAG")
  private String doag;

  @JsonProperty("margin_weight")
  private String marginWeight;

  private String owner;

  private String quoteApfWeighted;

  private String quoteAptWeighted;

  private String quoteMargin;

  private String quoteMarginWeighted;

  @JsonProperty("sumGrossMarginFieldBBL")
  private QuotePriceRequestDTO totalGrossMarginBBL;

  @JsonProperty("currTotalRebate")
  private QuotePriceRequestDTO totalMFAPS;

  @JsonProperty("currTotal")
  private QuotePriceRequestDTO totalProductPrice;

  @JsonProperty("aggProductionExpenseField")
  private QuotePriceRequestDTO totalProductionExpense;

  @JsonProperty("netTotal")
  private QuotePriceRequestDTO totalRevenue;

  @JsonProperty("totalVolumeBarrels")
  private String totalVolumeBBL;

  @JsonProperty("unifiedTotalVolumeL15")
  private String totalVolumeL15;

  @JsonProperty("unifiedTotalVolumeUG6")
  private String totalVolumeUG6;

  @JsonProperty("MBU")
  private String mbu;

  private String priceListName;

}
