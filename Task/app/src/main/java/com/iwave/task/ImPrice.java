
package com.iwave.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImPrice {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("attributes")
    @Expose
    private Attributes_ attributes;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes_ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes_ attributes) {
        this.attributes = attributes;
    }

}
