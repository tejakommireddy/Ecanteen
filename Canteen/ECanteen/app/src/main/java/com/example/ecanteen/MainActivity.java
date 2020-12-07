package com.example.ecanteen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button admin,user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        admin = (Button) findViewById(R.id.admin);
        user = (Button) findViewById(R.id.user);
        admin.setOnClickListener(this);
        user.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v.getId() ==  R.id.admin){
            Intent i=new Intent(this,admin.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.user) {
            Intent i=new Intent(this,user.class);
            startActivity(i);
        }
    }
}
