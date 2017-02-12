package xcal.cs.math.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class MultiplicationResponse {

  @JsonProperty
  @NotNull
  private int product;

  public MultiplicationResponse(int product) {
    this.product = product;
  }

  @SuppressWarnings("unused") // for Jackson
  private MultiplicationResponse() {}

  public int getProduct() {
    return product;
  }
}
