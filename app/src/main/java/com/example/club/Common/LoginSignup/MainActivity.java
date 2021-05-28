package com.example.club.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;

import com.example.club.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void callSignUpFromLogin(View view) {


        Intent intent = new Intent(getApplicationContext(), SignUp.class);


        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair(findViewById(R.id.createAccount), "transition_create_account");


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }


    }

    public void Lognow(View view){
        Intent intent = new Intent(getApplicationContext(), ForgetPassword.class);
        Toast.makeText(MainActivity.this, "Wrong Credentials! Try again.",Toast.LENGTH_SHORT).show();
    }

    public void callForgetPassword(View view) {


        Intent intent = new Intent(getApplicationContext(), ForgetPassword.class);


        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair(findViewById(R.id.ForgotPwd), "trans_forgot_pwd");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }


    }


}