package com.example.club.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.club.R;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp3rdClass extends AppCompatActivity {

    ImageView backBtn;
    Button next, login;
    ScrollView scrollView;
    TextView titleText;
    TextInputLayout phoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up3rd_class);

        phoneNumber = findViewById(R.id.sign_up_phone_num);
        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titleText = findViewById(R.id.signup_title_text);


    }

    /*
      public void callVerifyOTPScreen(View view) {



    if (!validatePhoneNumber()) {
        return;
    }


    String _fullName = getIntent().getStringExtra("fullName");
    String _email = getIntent().getStringExtra("email");
    String _username = getIntent().getStringExtra("username");
    String _password = getIntent().getStringExtra("password");
    String _date = getIntent().getStringExtra("date");
    String _type = getIntent().getStringExtra("type");
    String _phoneNo = getIntent().getStringExtra("phoneNo");

    //Get complete phone number
    String _getUserEnteredPhoneNumber = phoneNumber.getEditText().getText().toString().trim();

    //Remove first zero if entered!
    if (_getUserEnteredPhoneNumber.charAt(0) == '0') {
        _getUserEnteredPhoneNumber = _getUserEnteredPhoneNumber.substring(1);
    }



    Intent intent = new Intent(getApplicationContext(), VerifyOtp.class);


    //Pass all fields to the next activity
    intent.putExtra("fullName",_fullName);
    intent.putExtra("email", _email);
    intent.putExtra("username", _username);
    intent.putExtra("password", _password);
    intent.putExtra("date", _date);
    intent.putExtra("type", _type);
    intent.putExtra("phoneNo", _phoneNo);
    intent.putExtra("whatToDO", "createNewUser"); // This is to identify that which action should OTP perform after verification.




    Pair[] pairs = new Pair[4];

    pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
    pairs[1] = new Pair<View, String>(next, "transition_next_btn");
    pairs[2] = new Pair<View, String>(login, "transition_login_btn");
    pairs[3] = new Pair<View, String>(titleText, "transition_title_text");

    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp3rdClass.this, pairs);
        startActivity(intent, options.toBundle());
    } else {
        startActivity(intent);

    }

}


private boolean validatePhoneNumber() {
    String val = phoneNumber.getEditText().getText().toString().trim();
    String checkspaces = "Aw{1,20}z";
    if (val.isEmpty()) {
        phoneNumber.setError("Enter valid phone number");
        return false;
    } else if (!val.matches(checkspaces)) {
        phoneNumber.setError("No White spaces are allowed!");
        return false;
    } else {
        phoneNumber.setError(null);
        phoneNumber.setErrorEnabled(false);
        return true;
    }
}

     */


    public void callVerifyOTPScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), VerifyOtp.class);

        Pair[] pairs = new Pair[1];

        pairs[0] = new Pair(findViewById(R.id.signup_next_button), "transition_next_btn");
      /*  pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        pairs[2] = new Pair<View, String>(login, "transition_login_btn");
        pairs[3] = new Pair<View, String>(titleText, "transition_title_text");

       */

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp3rdClass.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);

        }

    }




    public void callLoginScreen(View view) {
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

}