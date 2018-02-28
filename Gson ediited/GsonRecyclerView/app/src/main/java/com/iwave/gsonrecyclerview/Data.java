package com.iwave.gsonrecyclerview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 2/28/2018.
 */

public class Data {
    @SerializedName("name")
    @Expose
    private Feed feed;

    public Feed getFeed() {
        return feed;
    }

    public void setName(Feed feed) {
        this.feed = feed;
    }
}