package com.example.ecanteen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

public class Items extends AppCompatActivity implements
        AdapterView.OnItemClickListener,View.OnClickListener{
    AutoCompleteTextView atv;
    SQLiteDatabase db;
    Button locate;
    ListView lv;
    String days[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        lv=findViewById(R.id.list);
        locate = (Button)findViewById(R.id.locate);
        // Creating database and table  
        db = openOrCreateDatabase("CanteenDB1", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Canteen1(item VARCHAR);");
        Cursor c = db.rawQuery("SELECT * FROM Canteen1", null);
        // Appending records to a string buffer 
        StringBuffer buffer = new StringBuffer();
        days = new String[c.getCount()];
        int i=0;
        while (c.moveToNext())
        {
                days[i] = c.getString(0);
            i++;
        }
        //android.R.layout.simple_list_item_1
        ArrayAdapter<String> ada=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                days);
        atv= (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        atv.setThreshold(1);
        atv.setAdapter(ada);
        atv.setTextColor(Color.BLUE);
        lv.setAdapter(ada);
        atv.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                atv.showDropDown();
                return false;
            }
        });
        lv.setOnItemClickListener(this);
        locate.setOnClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }
    @Override
    public void onClick(View v){
        if(v.getId() == R.id.locate){
            Uri uri = Uri.parse("geo:0,0?q=16.9385,82.0761(Google+mamidada)");
            Intent in = new Intent(Intent.ACTION_VIEW, uri);
            in.setPackage("com.google.android.apps.maps");
            startActivity(in);
        }
    }
}
