package com.harshtech.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) searchItem.getActionView();

        return super.onCreateOptionsMenu(menu);
    }
}