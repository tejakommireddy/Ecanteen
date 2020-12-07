package com.example.ecanteen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewCan extends AppCompatActivity implements View.OnClickListener{
    Button CanteenA,CanteenB,locate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_can);
        CanteenA = (Button) findViewById(R.id.canteenA);
        CanteenB = (Button) findViewById(R.id.canteenB);
        CanteenA.setOnClickListener(this);
        CanteenB.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.canteenA){
            Intent i=new Intent(this,Itema.class);
            startActivity(i);
        }
        else  if(v.getId() == R.id.canteenB){
            Intent i=new Intent(this,Items.class);
            startActivity(i);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
