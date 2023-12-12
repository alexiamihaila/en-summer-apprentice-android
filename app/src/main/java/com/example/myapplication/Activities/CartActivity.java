package com.example.myapplication.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapters.CartAdapter;
import com.example.myapplication.Adapters.EventsAdapter;
import com.example.myapplication.Domains.CartDomain;
import com.example.myapplication.Domains.EventsDomain;
import com.example.myapplication.R;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initRecyclerView();
    }

    private void initRecyclerView(){
        ArrayList<CartDomain> eventsDomainArrayList = new ArrayList<>();


        eventsDomainArrayList.add(new CartDomain("Untold",1000, "Muzica electronica", "pic"));
        eventsDomainArrayList.add(new CartDomain("Electric Castle",600, "Muzica electronica ", "pic"));
        eventsDomainArrayList.add(new CartDomain("Wine festival",200, "Festival de vin", "pic"));

        recyclerView=findViewById(R.id.vieworder);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        adapter = new CartAdapter(eventsDomainArrayList);

        recyclerView.setAdapter(adapter);
    }
}
