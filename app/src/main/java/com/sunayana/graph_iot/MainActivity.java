package com.sunayana.graph_iot;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUser, editTextPass;
    private TextView Info;
    private Button btnLogin;
    private int counter = 5;
    RelativeLayout rellay1;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler.postDelayed(runnable, 2000);
        rellay1 = (RelativeLayout)findViewById(R.id.rellay1);

        editTextUser = (EditText)findViewById(R.id.editText_user);
        editTextPass = (EditText)findViewById(R.id.editText_pass);
        btnLogin = (Button)findViewById(R.id.btn);
        Info = (TextView)findViewById(R.id.text_info);


        Info.setText("No of attempts remaining : 5");
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(editTextUser.getText().toString(),
                        editTextPass.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPass){
        if((userName.equals("Admin")) && (userPass.equals("1234"))){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }else{
            counter--;
            Info.setText("No of attempts remaining : " + String.valueOf(counter));
            if(counter == 0){
                btnLogin.setEnabled(false);
            }
        }
    }
}
