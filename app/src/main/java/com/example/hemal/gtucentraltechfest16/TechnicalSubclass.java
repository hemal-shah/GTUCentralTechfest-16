package com.example.hemal.gtucentraltechfest16;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hemal on 5/2/16.
 */
public class TechnicalSubclass extends AppCompatActivity {
    RecyclerView recyclerView;
    DepartmentAdapter adapter;
    SpanSpace spanSpace = new SpanSpace(16);
    List<String> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.technical_subclass);

        recyclerView = (RecyclerView) findViewById(R.id.rv_technical_subclass);

        String[] departmentNames = {"Mechanical", "Electrical-EC-IC", "Computer-IT-MCA", "Textile", "Civil", "Chemical"};
        list = Arrays.asList(departmentNames);

        adapter = new DepartmentAdapter(list, this, R.layout.department_row);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.addItemDecoration(spanSpace);
        recyclerView.setAdapter(adapter);
    }


}
