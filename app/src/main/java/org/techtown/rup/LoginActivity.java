package org.techtown.rup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button registerButton;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       registerButton=(Button)findViewById(R.id.registerbtn);
       loginButton=(Button)findViewById(R.id.loginbtn);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerintent=new Intent(LoginActivity.this,Register.class);
                LoginActivity.this.startActivity(registerintent);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginintent=new Intent(LoginActivity.this,MainActivity.class);
                LoginActivity.this.startActivity(loginintent);
            }
        });
    }
}