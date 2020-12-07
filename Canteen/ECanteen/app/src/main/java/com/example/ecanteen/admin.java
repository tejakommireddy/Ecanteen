package com.example.ecanteen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
public class admin extends AppCompatActivity implements View.OnClickListener{
    Button signup,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Bundle b=getIntent().getExtras();
        signup = (Button) findViewById(R.id.signup);
        login = (Button) findViewById(R.id.login);
        signup.setOnClickListener(this);
        login.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.signup){
            Intent i=new Intent(this,signup.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.login){
            Intent i=new Intent(this,login.class);
            startActivity(i);
        }
    }
}
