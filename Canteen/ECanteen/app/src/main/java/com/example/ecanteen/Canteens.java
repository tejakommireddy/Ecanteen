package com.example.ecanteen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Canteens extends AppCompatActivity implements View.OnClickListener{
    Button CanteenA,CanteenB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteens);
        CanteenA = (Button) findViewById(R.id.canteenA);
        CanteenB = (Button) findViewById(R.id.canteenB);
        CanteenA.setOnClickListener(this);
        CanteenB.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.canteenA){
            Intent i=new Intent(this,CanteenA.class);
            startActivity(i);
        }
        else  if(v.getId() == R.id.canteenB){
            Intent i=new Intent(this,CanteenB.class);
            startActivity(i);
        }
    }
}
