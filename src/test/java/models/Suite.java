package models;

import io.cucumber.messages.internal.com.google.gson.annotations.Expose;
import io.cucumber.messages.internal.com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Suite {
    @Expose
    @SerializedName("SuiteName")
    private String suiteName;
    @Expose
    @SerializedName("SuiteDescription")
    private String suiteDescription;
    @Expose
    @SerializedName("SuitePreconditions")
    private String suitePreconditions;
}
