package com.harshtech.regidatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name=findViewById(R.id.editTextTextPersonName);
        EditText address=findViewById(R.id.editTextTextPersonName2);
        EditText contact=findViewById(R.id.editTextTextPersonName3);
        EditText email=findViewById(R.id.editTextTextPersonName4);
        EditText dob=findViewById(R.id.editTextDate);
        EditText password=findViewById(R.id.editTextTextPassword);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Are you sure?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                DBmanager dBmanager=new DBmanager(getApplicationContext());
                                boolean bool= dBmanager.insertdata(name.getText().toString(),address.getText().toString(),contact.getText().toString(),email.getText().toString(),dob.getText().toString(),password.getText().toString());
                                if(bool=true){
                                    Toast.makeText(getApplicationContext(),"Register Successfully",Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(getApplicationContext(),"Something Wrong",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getApplicationContext(),name.getText().toString()+" "+address.getText().toString()+" "+contact.getText().toString()+" "+email.getText().toString()+" "+dob.getText().toString(),Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();




            }
        });

        findViewById(R.id.textView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}