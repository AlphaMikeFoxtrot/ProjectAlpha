package com.anonymous.library;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    Button mRegister, mSignIn;
    EditText mNewUsername, mNewPassword, mNewPasswordConfirm;
    ProgressDialog registerProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mRegister = findViewById(R.id.register_button);
        mSignIn = findViewById(R.id.sign_in_button);

        mNewUsername = findViewById(R.id.register_username);
        mNewPassword = findViewById(R.id.register_password);
        mNewPasswordConfirm = findViewById(R.id.register_password_confirmation);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mNewPassword.getText().toString().equals(mNewPasswordConfirm.getText().toString())){
                    register(mNewUsername.getText().toString(), mNewPassword.getText().toString());
                }
            }
        });

        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toSignIn = new Intent(RegisterActivity.this, LoginActivity.class);
                toSignIn.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(toSignIn);
            }
        });
    }

    private void register(String newUsername, String newPassword) {



    }
}
