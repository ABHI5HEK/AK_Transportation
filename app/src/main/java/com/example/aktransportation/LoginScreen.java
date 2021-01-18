package com.example.aktransportation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {
 private Button LoginButton, SignUp;
 Animation sideAnim;
 ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_login_screen);
        LoginButton = findViewById(R.id.login);
        SignUp =findViewById(R.id.signup);
        iv = findViewById(R.id.truckimg);
        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        iv.setAnimation(sideAnim);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginScreen.this, "Logging in...", Toast.LENGTH_SHORT).show();
                Intent LoginIntent  = new Intent(LoginScreen.this,Home.class);
                startActivity(LoginIntent);
                finish();
            }

        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SignIntent  = new Intent(LoginScreen.this,SignUpActivity.class);
                startActivity(SignIntent);
            }
        });
    }

    @Override
    protected void onPause() {
        finish();
        super.onPause();

    }
}