package com.example.admin.flirtalert.graph_api.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 1/1/2017.
 */

public class Summary {
    @SerializedName("total_count") int totalCount;

    public Summary(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}
