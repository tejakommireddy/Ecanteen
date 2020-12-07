package com.example.ecanteen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class view extends AppCompatActivity implements View.OnClickListener{
    Button con;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        con = (Button)findViewById(R.id.con);
        con.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if (v.getId() == R.id.con) {
            // Creating database and table  
            db = openOrCreateDatabase("CanteenDB", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS Canteen(item VARCHAR);");
            // Retrieving all records 
            Cursor c = db.rawQuery("SELECT * FROM Canteen", null);
            // Checking if no records found 
            if (c.getCount() == 0) {
                showMessage("Error", "No items found");
                return;
            }
            // Appending records to a string buffer 
            StringBuffer buffer = new StringBuffer();
            while (c.moveToNext())
            {
                buffer.append("Item: " + c.getString(0) + "\n");
            }
            // Displaying all records 
            showMessage("Items Details", buffer.toString());
        }

    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
