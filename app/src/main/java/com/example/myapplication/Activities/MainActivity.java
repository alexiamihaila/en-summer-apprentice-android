package com.example.myapplication.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapters.EventsAdapter;
import com.example.myapplication.Domains.EventsDomain;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initRecyclerView(){
        ArrayList<EventsDomain> eventsDomainArrayList = new ArrayList<>();


        eventsDomainArrayList.add(new EventsDomain("Untold",1000, "Muzica electronica", "pic"));
        eventsDomainArrayList.add(new EventsDomain("Electric Castle",600, "Muzica electronica ", "pic"));
        eventsDomainArrayList.add(new EventsDomain("Wine festival",200, "Festival de vin", "pic"));

        recyclerView=findViewById(R.id.vieworder);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        adapter = new EventsAdapter(eventsDomainArrayList);

        recyclerView.setAdapter(adapter);
    }
}
