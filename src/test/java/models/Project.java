package models;

import io.cucumber.messages.internal.com.google.gson.annotations.Expose;
import io.cucumber.messages.internal.com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    @Expose
    @SerializedName("ProjectName")
    private String projectName;
    @Expose
    @SerializedName("projectCode")
    private String projectCode;
    @Expose
    @SerializedName("ProjectDescription")
    private String projectDescription;
    @Expose
    @SerializedName("Access")
    private String access;
}
