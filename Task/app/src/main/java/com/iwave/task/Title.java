
package com.iwave.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Title {

    @SerializedName("label")
    @Expose
    private static String label;

    public static String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
