package com.example.admin.flirtalert.graph_api.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Admin on 1/1/2017.
 */

public class GetFriendsResponseBody {
    @SerializedName("summary") Summary summary;

    @SerializedName("data")
    ArrayList<Friend> friendList;

    public GetFriendsResponseBody(Summary summary, ArrayList<Friend> friendList) {
        this.summary = summary;
        this.friendList = friendList;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public ArrayList<Friend> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<Friend> friendList) {
        this.friendList = friendList;
    }

}
