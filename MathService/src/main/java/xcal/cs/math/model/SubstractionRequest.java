package xcal.cs.math.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by robinwang on 10/31/16.
 */
public class SubstractionRequest {
    @JsonProperty
    @NotNull
    private Integer minuend;

    @JsonProperty
    @NotNull
    private Integer substrachend;

    public SubstractionRequest(int minuend, int substrachend) {
        this.minuend = minuend;
        this.substrachend = substrachend;
    }

    @SuppressWarnings("unused") // for Jackson
    public SubstractionRequest() {
    }

    public Integer getMinuend() {
        return minuend;
    }

    public Integer getSubstrachend() {
        return substrachend;
    }
}
