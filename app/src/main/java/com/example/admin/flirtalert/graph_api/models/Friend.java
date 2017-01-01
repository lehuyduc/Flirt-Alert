package com.example.admin.flirtalert.graph_api.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 1/1/2017.
 */

public class Friend {
    @SerializedName("id") String id;

    @SerializedName("name") String name;

    public Friend(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /*
        {
            name:
            id:
            friendList: [
                {
                    name: friend1
                    id:
                    rank: friend with benefit
                    message:
                },
                {
                    name: friend2
                    todoList: [
                        {
                            content: go out
                            rank: very want
                            message: =
                        },
                        {

                        }
                    ]
                }
            ]

     */

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

    @Override
    public String toString() {
        return "Friend{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
