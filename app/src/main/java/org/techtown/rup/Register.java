package org.techtown.rup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class Register extends AppCompatActivity {

    private static String IP_ADDRESS="172.0.0.1";
    private static String TAG="phptest";

    private EditText id,pw,email;
    private RadioButton gender;
    private ArrayAdapter adapter;
    private Spinner spinner;
    Button registerBtn;
    String id_d,pw_d,email_d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerBtn=(Button)findViewById(R.id.registerbtn);
        id=(EditText)findViewById(R.id.idtext);
        pw=(EditText)findViewById(R.id.pwtext);
        email=(EditText)findViewById(R.id.emailtext);





        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent loginintent=new Intent(Register.this,LoginActivity.class);
                //Register.this.startActivity(loginintent);
                id_d=id.getText().toString();
                pw_d=pw.getText().toString();
                email_d=email.getText().toString();




            }
        });

        spinner=(Spinner)findViewById(R.id.majorspinner);
        adapter= ArrayAdapter.createFromResource(this,R.array.major, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }
}