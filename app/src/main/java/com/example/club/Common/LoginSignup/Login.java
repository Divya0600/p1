package com.example.club.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import com.example.club.R;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    TextInputLayout phoneNumber, password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        phoneNumber = findViewById(R.id.login_phone_number);
        password = findViewById(R.id.login_password);

    }


    public void callSignUpFromLogin(View view) {


        Intent intent = new Intent(getApplicationContext(), SignUp.class);


        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair(findViewById(R.id.createAccount), "transition_create_account");


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }


    }

    public void callForgetPassword(View view) {


        Intent intent = new Intent(getApplicationContext(), ForgetPassword.class);


        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair(findViewById(R.id.ForgotPwd), "trans_forgot_pwd");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }


    }


    private boolean validateFields() {
        String _phoneNumber = phoneNumber.getEditText().getText().toString().trim();
        String _password = password.getEditText().getText().toString().trim();

        if (_phoneNumber.isEmpty()) {
            phoneNumber.setError("Phone Number cannot be Empty");
            phoneNumber.requestFocus();
            return false;
        } else if (_password.isEmpty()) {
            password.setError("Password can not be empty");
            password.requestFocus();
            return false;
        } else {
            return true;
        }
    }


    public void letTheUserLoggedIn(View view) {
        if (!validateFields()) {
            return;
        }

        String _phoneNumber = phoneNumber.getEditText().getText().toString().trim();
        String _password = password.getEditText().getText().toString().trim();
        


        String _completePhoneNumber = "+" + _phoneNumber;


    }


    public void LogUser(View view) {
    }
}

