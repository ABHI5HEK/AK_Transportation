package com.example.aktransportation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
private Button Register, Login;
EditText mobile, password, confirmpassword, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_sign_up);
        Register = findViewById(R.id.signup);
        Login = findViewById(R.id.backtologin);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirm_password);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignUpActivity.this, "Registration successfull", Toast.LENGTH_SHORT).show();

                Intent SignupIntent  = new Intent(SignUpActivity.this,LoginScreen.class);
                startActivity(SignupIntent);


                finish();
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent  = new Intent(SignUpActivity.this,LoginScreen.class);
                startActivity(LoginIntent);
                finish();
            }
        });
    }
}