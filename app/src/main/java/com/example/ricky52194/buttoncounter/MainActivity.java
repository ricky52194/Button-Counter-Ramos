package com.example.ricky52194.buttoncounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button addButton;
    private Button subtractButton;
    private Button resetButton;
    private TextView count;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = findViewById(R.id.count);
        if(savedInstanceState != null){
            counter = Integer.parseInt(savedInstanceState.getString("currentValue"));
            count.setText(Integer.toString(counter));
        }else{
            counter = Integer.parseInt(count.getText().toString());
        }
        addButton = findViewById(R.id.add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                count.setText(Integer.toString(counter));
            }
        });
        subtractButton = findViewById(R.id.subtract);
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                count.setText(Integer.toString(counter));
            }
        });
        resetButton = findViewById(R.id.reset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count.setText(R.string.initial);
                counter = Integer.parseInt(count.getText().toString());
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("currentValue", count.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        counter = Integer.parseInt(savedInstanceState.getString("currentValue"));
    }


}
