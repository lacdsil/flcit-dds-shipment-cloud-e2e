package quote.spaQuote.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SPAQuoteRequestDTO {

  @JsonProperty("UUID")
  private String id;

  @JsonProperty("header")
  private SPAQuoteHeaderRequestDTO spaQuoteHeaderRequestDTO;

  @JsonProperty("line")
  private SPAQuoteLineRequestDTO spaQuoteLineRequestDTO;
}
