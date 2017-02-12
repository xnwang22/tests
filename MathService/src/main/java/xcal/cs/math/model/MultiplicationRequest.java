package xcal.cs.math.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class MultiplicationRequest {

  @JsonProperty
  @NotNull
  private Integer multiplicand;

  @JsonProperty
  @NotNull
  private Integer multiplier;

  public MultiplicationRequest(int multiplicand, int multiplier) {
    this.multiplicand = multiplicand;
    this.multiplier = multiplier;
  }

  @SuppressWarnings("unused") // for Jackson
  private MultiplicationRequest() {}

  public int getMultiplicand() {
    return multiplicand;
  }

  public int getMultiplier() {
    return multiplier;
  }
}
