package com.example.furnitures;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerview;
    private static ArrayList<DataModel> data;
    private Context mcontext;
    private static RecyclerView.Adapter adapter2;
    private RecyclerView.LayoutManager layoutManager2;
    private static RecyclerView recyclerview2;
    private static ArrayList<DataModel> data2;
    private Context mcontext2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiatemaincards();
        initiatesecondarycards();
        
    }

    private void initiatesecondarycards() {
        recyclerview2=findViewById(R.id.recyclerViewSecondary);
        recyclerview2.setHasFixedSize(true);
        layoutManager2=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerview2.setLayoutManager(layoutManager2);
        recyclerview2.setItemAnimator(new DefaultItemAnimator());

        data2 = new ArrayList<DataModel>();
        for (int i = 0; i < MyData2.nameArray.length; i++) {
            data2.add(new DataModel(MyData2.nameArray[i], MyData2.versionArray[i], MyData2.id[i], MyData2.drawwableArray[i]));
        }

        adapter2=new customAdapter2(data2,this);
        recyclerview2.setAdapter(adapter2);

    }

    private void initiatemaincards() {
        recyclerview=findViewById(R.id.recyclerViewPrimary);
        recyclerview.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            data.add(new DataModel(MyData.nameArray[i], MyData.versionArray[i], MyData.id[i], MyData.drawwableArray[i]));
        }

        adapter=new customAdapter(data,this);
        recyclerview.setAdapter(adapter);

    }
}