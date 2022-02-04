package com.harshtech.regidatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText name=findViewById(R.id.editTextTextPersonName5);
        EditText mobile=findViewById(R.id.editTextTextPersonName6);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cr=new DBmanager(getApplicationContext()).fetchdata(name.getText().toString());
                Toast.makeText(getApplicationContext(),"Hello Login",Toast.LENGTH_SHORT).show();
                Log.d("harsh", cr.getString((int)cr.getColumnIndex("NAME")));

//                Toast.makeText(getApplicationContext(),cr.getColumnIndex("password"),Toast.LENGTH_SHORT).show();
            }
        });
    }
}