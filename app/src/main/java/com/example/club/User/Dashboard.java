package com.example.club.User;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.club.Common.LoginSignup.MemberStartUp_Screen;
import com.example.club.R;

public class Dashboard extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

    }

    public void callMember(View view) {

        Intent intent = new Intent(getApplicationContext(), MemberStartUp_Screen.class);

        Pair[] pairs = new Pair[1];

        pairs[0] = new Pair<View, String>(findViewById(R.id.button), "logsign");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Dashboard.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);

        }

    }

}