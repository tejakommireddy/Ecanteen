package com.example.ecanteen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class remove extends AppCompatActivity implements View.OnClickListener{
    EditText item;
    Button con;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);
        item = (EditText)findViewById(R.id.item);
        con = (Button)findViewById(R.id.con);
        con.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if (v.getId() == R.id.con) {
            // Creating database and table  
            db = openOrCreateDatabase("CanteenDB", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS Canteen(item VARCHAR);");
            // Searching roll number 
            Cursor c = db.rawQuery("SELECT * FROM Canteen WHERE item='" + item.getText() + "'", null);
            if (c.moveToFirst()) {
                // Deleting record if found 
                showMessage("Success", "Record Deleted");
                db.execSQL("DELETE FROM Canteen WHERE item='" + item.getText() + "'");
            } else {
                showMessage("Error", "Invalid Item");
            }
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
