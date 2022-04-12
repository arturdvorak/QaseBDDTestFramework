package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
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
