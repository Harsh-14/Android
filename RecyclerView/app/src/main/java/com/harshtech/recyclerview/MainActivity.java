package com.harshtech.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> data=new ArrayList<String>();
        data.add("CPP");
        data.add("Python");
        data.add("java");
        data.add("Kotlin");
        data.add("CPP");
        data.add("Python");
        data.add("java");
        data.add("Kotlin");
        data.add("CPP");
        data.add("Python");
        data.add("java");
        data.add("Kotlin");

        recyclerView=findViewById(R.id.recy_view);
        recyclerView.setAdapter(new RecyAdapter(data));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}