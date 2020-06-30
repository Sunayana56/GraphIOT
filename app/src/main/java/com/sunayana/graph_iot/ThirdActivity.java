package com.sunayana.graph_iot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView DispMachId = (TextView)findViewById(R.id.dispMachId);
        Bundle bundle1 = getIntent().getExtras();
        String machText = bundle1.getString("machine");
        DispMachId.setText(machText);

    }

    public void viewGraph(View view){
        Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
        Bundle bundle1 = getIntent().getExtras();
        String num = bundle1.getString("machine_no");
        Bundle bundle = new Bundle();
        bundle.putString("machine_no", num);

        switch (view.getId()) {
            case R.id.machine:
                String getText1 = "Machine";
                bundle.putString("type", getText1);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

            case R.id.comp:
                String getText2 = "Component";
                bundle.putString("type", getText2);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

            case R.id.subComp:
                String getText3 = "SubComponent";
                bundle.putString("type", getText3);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }
}