package com.example.questionarioimpacto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SectionsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SectionAdapter sectionAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    List <String> sectionExample = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sections);

        sectionExample.add("Clima urbano");
        sectionExample.add("Crise energética");
        sectionExample.add("Clima urbano");
        sectionExample.add("Modelo de Programa Minha casa, Minha vida");
        sectionExample.add("Aplicação incompleta do programa");

        recyclerView = (RecyclerView) findViewById(R.id.rv_sections);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        sectionAdapter = new SectionAdapter(sectionExample);
        recyclerView.setAdapter(sectionAdapter);


    }
}
