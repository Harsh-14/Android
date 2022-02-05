package com.harshtech.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SearchView searchView;
    RecyAdapter recyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        List<String> data=new ArrayList<String>();
        data.add("C++ is a cross-platform language that can be used to create high-performance applications. C++ was developed by Bjarne Stroustrup");
        data.add("Python is an interpreted, object-oriented, high-level programming language with dynamic semantics.");
        data.add("Java is a programming language and computing platform first released by Sun Microsystems in 1995");
        data.add("Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference. Kotlin is designed to interoperate fully with Java");
        data.add("C++ is a cross-platform language that can be used to create high-performance applications. C++ was developed by Bjarne Stroustrup");
        data.add("Python is an interpreted, object-oriented, high-level programming language with dynamic semantics.");
        data.add("Java is a programming language and computing platform first released by Sun Microsystems in 1995");
        data.add("Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference. Kotlin is designed to interoperate fully with Java");
        data.add("C++ is a cross-platform language that can be used to create high-performance applications. C++ was developed by Bjarne Stroustrup");
        data.add("Python is an interpreted, object-oriented, high-level programming language with dynamic semantics.");
        data.add("Java is a programming language and computing platform first released by Sun Microsystems in 1995");
        data.add("Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference. Kotlin is designed to interoperate fully with Java");

        recyclerView=findViewById(R.id.recy_view);
        recyAdapter=new RecyAdapter(data);
        recyclerView.setAdapter(recyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.d("harsh",s);
                recyAdapter.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}