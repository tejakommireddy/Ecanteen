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

public class signup extends AppCompatActivity implements View.OnClickListener {
    SQLiteDatabase db;
    EditText email,number,name,password,repassword;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        email = (EditText) findViewById(R.id.email);
        number = (EditText) findViewById(R.id.phone);
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        db = openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Signup(email VARCHAR,name VARCHAR,number VARCHAR,password VARCHAR,repassword VARCHAR);");
        if(v.getId() == R.id.submit){
            if(email.getText().toString().isEmpty() || number.getText().toString().isEmpty() ||
                name.getText().toString().isEmpty() || password.getText().toString().isEmpty() || repassword.getText().toString().isEmpty()) {
                Toast.makeText(this, "please fill all the details", Toast.LENGTH_SHORT).show();
            }
            else if(email.getText().toString().endsWith("@gmail.com") && number.getText().toString().length() == 10
            && name.getText().toString().matches("^[a-zA-z]+$") && password.getText().toString().matches("^[0-9]+$")
                && repassword.getText().toString().matches(password.getText().toString())){
                db.execSQL("INSERT INTO Signup VALUES('" + email.getText() + "','" + name.getText() +
                        "','" + number.getText() + "','" + password.getText() + "','" + repassword.getText()+"');");

                Intent i=new Intent(this,login.class);
                startActivity(i);
            }
            else{
                Toast.makeText(this,"invalid",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
