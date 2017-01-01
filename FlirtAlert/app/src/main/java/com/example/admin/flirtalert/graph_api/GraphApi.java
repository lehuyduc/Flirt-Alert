package com.example.admin.flirtalert.graph_api;

import android.os.Bundle;
import android.util.Log;

import com.example.admin.flirtalert.graph_api.models.Friend;
import com.example.admin.flirtalert.graph_api.models.GetFriendsResponseBody;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 1/1/2017.
 */

public class GraphApi {
    private static final String TAG = GraphApi.class.toString();

    public static void loadFriendList(String userId, final List<Friend> friendList) {
        if (userId==null) userId = "me";
        final GetFriendsResponseBody[] body = new GetFriendsResponseBody[1];

        if (AccessToken.getCurrentAccessToken()==null) {
            Log.d(TAG, "getFriendList: current access token is null");
            return;
        }

        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/" + userId + "/friends",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        Log.d(TAG, "GraphApi getFriendList onResponse");
                        Log.d(TAG, response.getRawResponse().toString());
                        GetFriendsResponseBody body = new Gson().fromJson(response.getRawResponse(),
                                                                            GetFriendsResponseBody.class);
                        friendList.clear();
                        friendList.addAll(body.getFriendList());
                        for (Friend friend : friendList)
                            Log.d(TAG, friend.toString());
                    }
                }
        ).executeAsync();
    }
}
