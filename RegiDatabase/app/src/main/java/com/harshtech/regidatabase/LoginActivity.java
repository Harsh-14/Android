package com.harshtech.regidatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
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
        EditText pass=findViewById(R.id.editTextTextPersonName6);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                Cursor cr=new DBmanager(getApplicationContext()).fetchdata(name.getText().toString());
                Toast.makeText(getApplicationContext(),"Hello Login",Toast.LENGTH_SHORT).show();
                while (cr.moveToNext()){
                    if(pass.getText().toString().equals(cr.getString(6))){
                        Log.d("harsh",cr.getString(6)+" "+cr.getString(1));
                        intent.putExtra("name",name.getText().toString());
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Wrong Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}