package com.example.club.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.example.club.R;

public class MakeSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_selection);
    }

    public void callOTPScreenFromMakeSelection(View view) {


        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);


        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair(findViewById(R.id.via_sms), "trans_via_sms");


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MakeSelection.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }


    }

    public void callBackScreenFromMakeSelection(View view) {


        Intent intent = new Intent(getApplicationContext(), ForgetPassword.class);


        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair(findViewById(R.id.make_selection_back), "trans_selection_back");


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MakeSelection.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }


    }
}