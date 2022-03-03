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
public class SPAQuoteHeaderRequestDTO {
  @JsonProperty("priceBookIndicator")
  private String priceBookIndicator;

  @JsonProperty("PROSAgreement__Agreement_Id")
  private String agreementId;

  @JsonProperty("PROSAgreement__StartDate")
  private String agreementStartDate;

  @JsonProperty("PROSAgreement__EndDate")
  private String agreementEndDate;

  @JsonProperty("salesOrgCode")
  private String salesOrg;

  @JsonProperty("displayCurrency")
  private String currency;

  @JsonProperty("priceListName")
  private String priceListName;

  @JsonProperty("firmPricing")
  private String firmPricing;

  @JsonProperty("quoteId")
  private String quoteId;

  @JsonProperty("firmPricingEndDateStrField")
  private String firmPricingEndDate;

  @JsonProperty("priceProtection")
  private String priceProtection;

  @JsonProperty("ppNumberDays")
  private String priceProtectionNumberDays;

  @JsonProperty("isFormulaPricing")
  private String formulaPricing;

  @JsonProperty("quoteTypeField")
  private String quoteType;

  @JsonProperty("quote_Score_Percentage")
  private String quoteScore;

  @JsonProperty("endCustomerField")
  private String endCustomerName;

  @JsonProperty("distributorName")
  private String distributorName;

  @JsonProperty("distributorNameShort")
  private String endCustomerShortName;

  @JsonProperty("distributorAccountAux")
  private String distributorAccountAux;

  @JsonProperty("distributorERP")
  private String distributorERP;

  @JsonProperty("distributorAccount")
  private String distributorAccount;

  @JsonProperty("distributor_account_type")
  private String distributorAccountType;

  @JsonProperty("spaReason")
  private String spaReason;

  @JsonProperty("legacyQuoteId")
  private String legacyQuoteId;

  @JsonProperty("MBU")
  private String mbu;

  @JsonProperty("aggProductionExpenseField")
  private QuotePriceRequestDTO totalProductionExpense;

  @JsonProperty("aggProductPriceField")
  private QuotePriceRequestDTO agreementProductPrice;

  @JsonProperty("apf_weight")
  private String apfWeight;

  @JsonProperty("apt_weight")
  private String aptWeight;

  @JsonProperty("currTotal")
  private QuotePriceRequestDTO totalProductPrice;

  @JsonProperty("currTotalRebate")
  private QuotePriceRequestDTO totalMFAPS;

  @JsonProperty("margin_weight")
  private String marginWeight;

  @JsonProperty("netTotal")
  private QuotePriceRequestDTO totalRevenue;

  private String owner;

  private String quoteApfWeighted;

  private String quoteAptWeighted;

  private String quoteMargin;

  private String quoteMarginWeighted;

  @JsonProperty("REV_DOAG")
  private String doag;

  @JsonProperty("sumGrossMarginFieldBBL")
  private QuotePriceRequestDTO totalGrossMarginBBL;

  @JsonProperty("totalVolumeBarrels")
  private String totalVolumeBBL;

  @JsonProperty("unifiedTotalVolumeL15")
  private String totalVolumeL15;

  @JsonProperty("unifiedTotalVolumeUG6")
  private String totalVolumeUG6;
}
