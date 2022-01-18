package com.mul.calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class calculated extends AppCompatActivity {
ListView list;
DatabaseHandler db;
int i = 0;
String history[]=new String[5000];
String history1[] = new String[5000];
Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculated);

        list = (ListView) findViewById(R.id.listView);

       db = new DatabaseHandler( calculated.this);
        //  db = new DatabaseHandler(this);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        Cursor res = db.getData();
        //StringBuffer bu = new StringBuffer();
        while(res.moveToNext()){
           // bu.append("col_1:"+res.getString(1)+"\n");
            history[i] = res.getString(1);
            i++;
        }
        for ( int i=0;i<5000;i++)
            history1[i] = "";

        if (i!=0){
            for (int j = i-1,k=0;j >= 0; j--,k++){
                history1[k] = history[j];
            }
        }
        ListAdapter historyAdaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,history1);
        list.setAdapter(historyAdaptor);
    }
}