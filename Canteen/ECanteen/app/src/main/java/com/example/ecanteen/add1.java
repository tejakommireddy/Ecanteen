package com.example.ecanteen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add1 extends AppCompatActivity implements View.OnClickListener{
    EditText item;
    Button con;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add1);
        item = (EditText)findViewById(R.id.item);
        con = (Button)findViewById(R.id.con);
        con.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.con) {
            // Checking empty fields
            if (item.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter all values");
                return;
            }
            // Creating database and table  
            db = openOrCreateDatabase("CanteenDB1", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS Canteen1(item VARCHAR);");
            // Inserting record 
            db.execSQL("INSERT INTO Canteen1 VALUES('" + item.getText() + "');");
            showMessage("Success", "Record added");
            clearText();
        }
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText(){
        item.setText("");
    }

}
