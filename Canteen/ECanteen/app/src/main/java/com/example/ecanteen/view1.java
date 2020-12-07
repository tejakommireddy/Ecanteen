package com.example.ecanteen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class view1 extends AppCompatActivity implements View.OnClickListener{
    Button con;
    SQLiteDatabase db1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view1);
        con = (Button)findViewById(R.id.con);
        con.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if (v.getId() == R.id.con) {
            // Creating database and table  
            db1 = openOrCreateDatabase("CanteenDB1", Context.MODE_PRIVATE, null);
            db1.execSQL("CREATE TABLE IF NOT EXISTS Canteen1(item VARCHAR);");
            // Retrieving all records 
            Cursor c1 = db1.rawQuery("SELECT * FROM Canteen1", null);
            // Checking if no records found 
            if (c1.getCount() == 0) {
                showMessage("Error", "No items found");
                return;
            }
            // Appending records to a string buffer 
            StringBuffer buffer1 = new StringBuffer();
            while (c1.moveToNext())
            {
                buffer1.append("Item: " + c1.getString(0) + "\n");
            }
            // Displaying all records 
            showMessage("Item Details", buffer1.toString());
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
