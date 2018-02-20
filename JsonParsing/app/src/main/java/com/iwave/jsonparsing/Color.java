
package com.iwave.jsonparsing;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Color {

    @SerializedName("colorName")
    @Expose
    private String colorName;
    @SerializedName("hexValue")
    @Expose
    private String hexValue;

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getHexValue() {
        return hexValue;
    }

    public void setHexValue(String hexValue) {
        this.hexValue = hexValue;
    }

}
