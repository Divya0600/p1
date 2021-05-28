package com.example.club.Common.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.example.club.Databases.UserHelperClass;
import com.example.club.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class VerifyOtp extends AppCompatActivity {

    PinView pinFromUser;
    String codeBySystem;
    String fullName,username,password,email,phoneNo,date,type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);

    //hooks
        pinFromUser = findViewById(R.id.pin_view);
        fullName = getIntent().getStringExtra("fullName");
        email = getIntent().getStringExtra("email");
        username = getIntent().getStringExtra("username");
         password = getIntent().getStringExtra("password");
        date = getIntent().getStringExtra("date");
        type = getIntent().getStringExtra("type");
        phoneNo = getIntent().getStringExtra("phoneNo");
        

         sendVerificationCodeToUser(phoneNo);

    }

    private void sendVerificationCodeToUser(String _phoneNo) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                _phoneNo,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallbacks);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks  mCallbacks =
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                @Override
                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    super.onCodeSent(s, forceResendingToken);
                    codeBySystem = s;
                }

                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                    String code = phoneAuthCredential.getSmsCode();
                    if (code!=null){
                        pinFromUser.setText(code);
                        verifyCode(code);
                    }


                }

                @Override
                public void onVerificationFailed(@NonNull FirebaseException e) {
                    Toast.makeText(VerifyOtp.this,e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            };

    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeBySystem,code);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {

        FirebaseAuth  firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential)

                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            storeNewUsersData();
                           

                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(VerifyOtp.this, "Verification Not Completed! Try again.",Toast.LENGTH_SHORT).show();

                            }
                        }
                    }
                });
    }

    private void storeNewUsersData() {
        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode.getReference("Users");
        // DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        UserHelperClass addNewUser = new UserHelperClass(fullName , username , email, phoneNo,password,date, type);

        reference.child(phoneNo).setValue(addNewUser);
    }

    public void callNextScreenFromOtp(View view) {


        String code = pinFromUser.getText().toString();
        if (!code.isEmpty()) {
            verifyCode(code);
        }
    }

    public void goToMakeSelectionFromOtp(View view) {
        startActivity(new Intent(getApplicationContext(), MakeSelection.class));
        finish();
    }

}