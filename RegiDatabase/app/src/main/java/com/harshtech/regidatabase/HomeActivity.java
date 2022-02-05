package com.harshtech.regidatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    TextView name;
    TextView email;
    TextView address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        name=findViewById(R.id.textView5);
        email=findViewById(R.id.textView6);
        address=findViewById(R.id.textView7);

        Cursor cr=new DBmanager(getApplicationContext()).fetchdata(getIntent().getStringExtra("name"));
        while (cr.moveToNext()){
            name.setText(cr.getString(1));
            email.setText(cr.getString(4));
            address.setText(cr.getString(2));
        }
    }
}