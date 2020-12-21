package org.techtown.rup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button QR_s,point_btn;
    private TextView pointTxt;
    private int point;
    private ImageView plant;
    //여기서부터 윤정코드
    private Button rank_btn,myinfo_btn;
    private MainActivity fragment_main;
    private RankActivity fragment_menu;
    private MyinfoActivity fragment_garden;
    private FragmentManager fm;
    private FragmentTransaction transaction;

    @Override
    public void onClick(View view) {
        scanCode();

    }
    private void scanCode(){
        IntentIntegrator integrator=new IntentIntegrator(this);
        integrator.setCaptureActivity(CaptureAct.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Scanning Code..");
        integrator.initiateScan();
        Log.d("QR","메인 액티비티!");
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        Log.d("QR","메인 액티비티!2");
        if(result!=null){
            if(result.getContents()!=null&&result.getContents().equals("포인트")){
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                //데이터 값을 getContents()를 통하여 메세지를 보여줌
                //builder.setMessage(result.getContents());
                //데이터 값을 비교한 후 포인트를 랜덤값으로 지불하여 기존 포인트값+신규 포인트 값

                    int pointRandom=(int)(Math.random()*99)+1;
                    builder.setMessage(pointRandom+"이 지급되었습니다.");
                    point+=pointRandom;
                    if(point<=100){
                        plant.setImageResource(R.drawable.seed);
                    }
                    else if(point>100&&point<=150){
                        plant.setImageResource(R.drawable.plant);
                    }
                    else if(point>150&&point<=500){
                        plant.setImageResource(R.drawable.flower);
                    }
                    pointTxt.setText(""+point);

                builder.setTitle("포인트를 적립하였습니다.");

                builder.setNegativeButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //finish();
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
            else{
                Toast.makeText(this,"No result",Toast.LENGTH_LONG).show();
            }
        }
        else{
            super.onActivityResult(requestCode,resultCode,data);

        }
    }







    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm=getSupportFragmentManager();



        transaction=fm.beginTransaction();
        //transaction.replace(R.id.framelayout,fragment_main).commitAllowingStateLoss();


        rank_btn=(Button)findViewById(R.id.rank_btn);
        myinfo_btn=(Button)findViewById(R.id.myinfo_btn);

        point_btn=(Button)findViewById(R.id.point_btn);
        QR_s=(Button)findViewById(R.id.QR_btn);
        QR_s.setOnClickListener(this);
        plant=(ImageView)findViewById(R.id.plant);
        pointTxt=(TextView)findViewById(R.id.point_txt);
        String pointS=pointTxt.getText().toString();
        point=Integer.parseInt(pointS);

        if(point<=100){
            plant.setImageResource(R.drawable.seed);
        }
        else if(point>100&&point<=150){
            plant.setImageResource(R.drawable.plant);
        }
        else if(point>150&&point<=500){
            plant.setImageResource(R.drawable.flower);
        }




        //QR시스템을 안드로이드 폰이 없어서 다른 방법으로 확인하기 위해서
        point_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                point+=1;
                pointTxt.setText(""+point);
                if(point<=100){
                    plant.setImageResource(R.drawable.seed);
                }
                else if(point>100&&point<=150){
                    plant.setImageResource(R.drawable.plant);
                }
                else if(point>150&&point<=500){
                    plant.setImageResource(R.drawable.flower);
                }

            }
        });





        rank_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new RankActivity()).commit();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                RankActivity fragment1= new RankActivity();
                transaction.replace(R.id.framelayout,fragment1);
                transaction.addToBackStack(null);//뒤쪽 스택으로 이동하여라
                transaction.commit();
            }
        });

        myinfo_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new MyinfoActivity()).commit();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                MyinfoActivity fragment2= new MyinfoActivity();
                transaction.replace(R.id.framelayout,fragment2);
                transaction.addToBackStack(null);//뒤쪽 스택으로 이동하여라
                transaction.commit();
            }
        });

    }

}