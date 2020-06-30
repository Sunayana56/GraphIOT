package com.sunayana.graph_iot;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void components(View view){
        Intent intent = new Intent(SecondActivity.this, FourthActivity.class);
        Bundle bundle = new Bundle();

        switch (view.getId()){
            case R.id.machine1:
                TextView text1 = (TextView) findViewById(R.id.machineText1);
                int machNo1 = 1;
                bundle.putInt("machine_no", machNo1);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

            case R.id.machine2:
                TextView text2 = (TextView) findViewById(R.id.machineText2);
                int machNo2 = 2;
                bundle.putInt("machine_no", machNo2);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

            case R.id.machine3:
                TextView text3 = (TextView) findViewById(R.id.machineText3);
                int machNo3 = 3;
                bundle.putInt("machine_no", machNo3);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

            case R.id.machine4:
                TextView text4 = (TextView) findViewById(R.id.machineText4);
                int machNo4 = 4;
                bundle.putInt("machine_no", machNo4);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

            case R.id.machine5:
                TextView text5 = (TextView) findViewById(R.id.machineText5);
                int machNo5 = 5;
                bundle.putInt("machine_no", machNo5);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

            case R.id.machine6:
                TextView text6 = (TextView) findViewById(R.id.machineText6);
                int machNo6 = 6;
                bundle.putInt("machine_no", machNo6);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

            case R.id.machine7:
                TextView text7 = (TextView) findViewById(R.id.machineText7);
                int machNo7 = 7;
                bundle.putInt("machine_no", machNo7);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

            case R.id.machine8:
                TextView text8 = (TextView) findViewById(R.id.machineText8);
                int machNo8 = 8;
                bundle.putInt("machine_no", machNo8);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }


    }
}


