package com.example.ecanteen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class login extends AppCompatActivity implements View.OnClickListener {
    EditText name,password;
    Button submit;
    //SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = (EditText)findViewById(R.id.name);
        password = (EditText)findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submit);
        /*db = openOrCreateDatabase("LoginDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Login(username VARCHAR,password VARCHAR);");
        db.execSQL("INSERT INTO Login VALUES(' " + "viswa" +" ',' " + "1234" +" ');");*/
        submit.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        String na = "viswa",ps = "1234";
        if(v.getId() == R.id.submit){
            if(name.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                Toast.makeText(this,"please fill all the details",Toast.LENGTH_SHORT).show();
            }
            else if(name.getText().toString().equals(na) && password.getText().toString().equals(ps)){
                Intent i=new Intent(this,Canteens.class);
                startActivity(i);
            }
            else {
                Toast.makeText(this,"invalid",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
