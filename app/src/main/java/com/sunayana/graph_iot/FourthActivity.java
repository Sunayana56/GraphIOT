package com.sunayana.graph_iot;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class FourthActivity extends AppCompatActivity {

    TextView disptxt;
    //EditText editTextX, editTextY1, editTextY2;
    //Button button;
    FirebaseDatabase database;
    DatabaseReference reference;
    GraphView graph;
    LineGraphSeries<DataPoint> series1, series2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        disptxt=(TextView) findViewById(R.id.disptext);
//        button=(Button) findViewById(R.id.button);
//        editTextX=(EditText) findViewById(R.id.editText_X);
//        editTextY1=(EditText) findViewById(R.id.editText_Y1);
//        editTextY2=(EditText) findViewById(R.id.editText_Y2);


        graph=(GraphView) findViewById(R.id.graph);
        series1 = new LineGraphSeries();
        series2 = new LineGraphSeries();
        graph.addSeries(series1);
        graph.addSeries(series2);
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);
        series1.setColor(Color.rgb(255, 0, 0));
        series2.setColor(Color.rgb(0, 0, 255));

        database = FirebaseDatabase.getInstance();

        Bundle bundle = getIntent().getExtras();
        int machine_no = bundle.getInt("machine_no");
        String text ="";

        switch (machine_no){
            case 1:
                reference = database.getReference("Machine1Table");
                break;

            case 2:
                reference = database.getReference("Machine2Table");
                break;

            case 3:
                reference = database.getReference("Machine3Table");
                break;

            case 4:
                reference = database.getReference("Machine4Table");
                break;

            case 5:
                reference = database.getReference("Machine5Table");
                break;

            case 6:
                reference = database.getReference("Machine6Table");
                break;

            case 7:
                reference = database.getReference("Machine7Table");
                break;

            case 8:
                reference = database.getReference("Machine8Table");
                break;

        }
        disptxt.setText(text);
        //setListeners();

    }

//    private void setListeners(){
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v){
//                String id= reference.push().getKey();
//                int xVal=Integer.parseInt(String.valueOf(editTextX.getText()));
//                int y1Val=Integer.parseInt(String.valueOf(editTextY1.getText()));
//                int y2Val=Integer.parseInt(String.valueOf(editTextY2.getText()));
//
//                PointValue pointValue = new PointValue(xVal,y1Val,y2Val);
//
//                reference.child(id).setValue(pointValue);
//
//            }
//        });
//    }

    @Override
    protected void onStart(){
        super.onStart();

        reference.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                DataPoint[] dp1 = new DataPoint[(int) dataSnapshot.getChildrenCount()];
                DataPoint[] dp2 = new DataPoint[(int) dataSnapshot.getChildrenCount()];
                int index = 0;

                for(DataSnapshot myDataSnapshot : dataSnapshot.getChildren())
                {
                    PointValue pointValue = myDataSnapshot.getValue(PointValue.class);
                    dp1[index] = new DataPoint(pointValue.getxValue(), pointValue.gety1Value());
                    index++;
                }
                series1.resetData(dp1);

                index=0;
                for(DataSnapshot myDataSnapshot : dataSnapshot.getChildren())
                {
                    PointValue pointValue = myDataSnapshot.getValue(PointValue.class);
                    dp2[index] = new DataPoint(pointValue.getxValue(), pointValue.gety2Value());
                    index++;
                }

                series2.resetData(dp2);
           }

            @Override
            public void onCancelled(DatabaseError databaseError){
            }
        });
   }
}



