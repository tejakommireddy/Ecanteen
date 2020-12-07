package com.example.ecanteen;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CanteenB extends AppCompatActivity implements View.OnClickListener {
    Button add,remove,view;
    String days[]={"ItemA","ItemB","ItemC"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen_b);
        add = (Button)findViewById(R.id.add);
        remove = (Button)findViewById(R.id.remove);
        view = (Button)findViewById(R.id.view);
        add.setOnClickListener(this);
        remove.setOnClickListener(this);
        view.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.add){
            Intent i=new Intent(this,add1.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.remove){
            Intent i=new Intent(this,remove1.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.view){
            Intent i=new Intent(this,view1.class);
            startActivity(i);
        }
    }
}
