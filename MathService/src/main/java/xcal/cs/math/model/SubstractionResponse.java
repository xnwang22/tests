package xcal.cs.math.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by robinwang on 10/31/16.
 */
public class SubstractionResponse {
    @JsonProperty
    @NotNull
    private Integer difference;

    public SubstractionResponse(int difference) {
        this.difference = difference;
    }

    @SuppressWarnings("unused") // for Jackson
    private SubstractionResponse() {}

    public Integer getDifference() {
        return difference;
    }
}
