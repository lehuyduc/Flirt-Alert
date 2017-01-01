package com.example.admin.flirtalert.graph_api.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Admin on 1/1/2017.
 */

public class User {
    @SerializedName("id") String id;

    @SerializedName("name") String name;

    @SerializedName("friend_list")
    ArrayList<Friend> friendList;

    public User(String id, String name, ArrayList<Friend> friendList) {
        this.id = id;
        this.name = name;
        this.friendList = friendList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Friend> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<Friend> friendList) {
        this.friendList = friendList;
    }
}
