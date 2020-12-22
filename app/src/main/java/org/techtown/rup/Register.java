package org.techtown.rup;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class Register extends AppCompatActivity {

    private static String IP_ADDRESS="172.0.0.1";
    private static String TAG="phptest";
<<<<<<< HEAD
    private EditText id,pw,email;
    private RadioButton sms_agree, sms_disagree;
    private RadioGroup radioGroup;
=======
    private RadioButton sms_agree,sms_disagree;
    private RadioGroup radioGroup;
    private EditText id,pw,email;
>>>>>>> 632a74670ca95818cfad2953728235f7bb4de59f
    private ArrayAdapter adapter;
    private Spinner spinner_year, spinner_month, spinner_day;
    private ArrayAdapter sp_year_ad, sp_month_ad, sp_day_ad;
    TextView text_year, text_month, text_day;
    Button registerBtn;
    String id_d,pw_d,email_d, select_year, select_month, select_day;
    EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("register","1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Log.d("register","2");

        registerBtn=(Button)findViewById(R.id.registerbtn);
        id=(EditText)findViewById(R.id.idtext);
        pw=(EditText)findViewById(R.id.pwtext);
        email=(EditText)findViewById(R.id.emailtext);
        phone=(EditText)findViewById(R.id.phonetext);
        sms_agree=(RadioButton)findViewById(R.id.sms_agree);
        sms_disagree=(RadioButton)findViewById(R.id.sms_disagree);
        sms_agree.setOnClickListener(radioButtonClickListener);
        sms_disagree.setOnClickListener(radioButtonClickListener);
<<<<<<< HEAD
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(radioGroupButtonChangeListener);

        phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());//전화번호에 하이픈 자동추가

        Log.d("register","3");

        spinner_year=(Spinner)findViewById(R.id.spinner_year);
        spinner_month=(Spinner)findViewById(R.id.spinner_month);
        spinner_day=(Spinner)findViewById(R.id.spinner_day);
        Log.d("register","4");
=======

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(radioGroupButtonChangeListener);
>>>>>>> 632a74670ca95818cfad2953728235f7bb4de59f

        ArrayAdapter sp_year_ad=ArrayAdapter.createFromResource(this,R.array.register_years,android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter sp_month_ad=ArrayAdapter.createFromResource(this,R.array.register_months,android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter sp_day_ad=ArrayAdapter.createFromResource(this,R.array.register_days,android.R.layout.simple_spinner_dropdown_item);
        Log.d("register","5");

        spinner_year.setAdapter(sp_year_ad);
        spinner_month.setAdapter(sp_month_ad);
        spinner_day.setAdapter(sp_day_ad);
        Log.d("register","6");


        spinner_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                select_year = adapterView.getAdapter().getItem(i).toString();
                Log.i("TEST", "selectedyear:::" + select_year);
            }
            public void onNothingSelected(AdapterView<?> parent){}
        });
        Log.d("register","7");

        
        spinner_month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                select_month= adapterView.getAdapter().getItem(i).toString();
                Log.i("TEST", "selectedyear:::" + select_month);
            }
            public void onNothingSelected(AdapterView<?> parent){}
        });
        Log.d("register","8");

        spinner_day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                select_day= adapterView.getAdapter().getItem(i).toString();
                Log.i("TEST", "selectedyear:::" + select_day);
            }
            public void onNothingSelected(AdapterView<?> parent){}
        });
        Log.d("register","9");

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent loginintent=new Intent(Register.this,LoginActivity.class);
                //Register.this.startActivity(loginintent);
                id_d=id.getText().toString();
                pw_d=pw.getText().toString();
                email_d=email.getText().toString();
<<<<<<< HEAD


            }
        });
        Log.d("register","10");
=======
                phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());//전화번호에 하이픈 자동추가

            }
        });
>>>>>>> 632a74670ca95818cfad2953728235f7bb4de59f

    }
    RadioButton.OnClickListener radioButtonClickListener=new RadioButton.OnClickListener(){
        @Override
        public void onClick(View v) {

        }
    };
    RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            if(i == R.id.sms_agree){

            }
            else if(i == R.id.sms_disagree){

            }
        }
    };
<<<<<<< HEAD
}
=======
}
>>>>>>> 632a74670ca95818cfad2953728235f7bb4de59f
