package com.example.admin.flirtalert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.admin.flirtalert.graph_api.GraphApi;
import com.example.admin.flirtalert.graph_api.models.Friend;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.toString();
    @BindView(R.id.login_button)
    LoginButton loginButton;

    @BindView(R.id.ppv_avatar)
    ProfilePictureView ppvAvatar;

    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        callbackManager = CallbackManager.Factory.create();
        loginButton.setReadPermissions("user_friends");
        getLoginDetail(loginButton);
    }

    private void getLoginDetail(LoginButton loginButton) {
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "Login onSuccess");
                ArrayList<Friend> friendList = new ArrayList<Friend>();
                GraphApi.loadFriendList(null, friendList);
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "Login onCancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "Login onError");
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
