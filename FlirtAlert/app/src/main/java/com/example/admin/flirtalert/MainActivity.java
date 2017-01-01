package com.example.admin.flirtalert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.bt_log_out)
    Button btLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if (AccessToken.getCurrentAccessToken()==null) {
            goToLoginScreen();
        }
    }

    private void goToLoginScreen() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK);
        Log.d(TAG, "goingToLoginScreen");
        startActivity(intent);
    }

    @OnClick(R.id.bt_log_out)
    public void onClickLogout(View view) {
        LoginManager.getInstance().logOut();
        goToLoginScreen();
    }
}
