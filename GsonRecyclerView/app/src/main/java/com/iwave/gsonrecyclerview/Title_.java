
package com.iwave.gsonrecyclerview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Title_ {

    @SerializedName("label")
    @Expose
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
