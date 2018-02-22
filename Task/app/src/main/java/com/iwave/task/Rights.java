
package com.iwave.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rights {

    @SerializedName("label")
    @Expose
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String urself) {
        this.label = urself;
    }

}
