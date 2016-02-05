package com.example.hemal.gtucentraltechfest16;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hemal on 5/2/16.
 */
public class EventsFragment extends Fragment {

    RecyclerView recyclerView;
    FieldsAdapter adapter;
    SpanSpace spanSpace = new SpanSpace(16);
    List<String> list;
    String[] events = {"Technical", "Non-Technical", "Robotics", "Exhibition", "ATV", "Workshops"};
//    ImageView technical, nonTechnical, exhibition, robotics, workshops, atv;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = Arrays.asList(events);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.events_fragment, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.rv_events_fragment);
        adapter = new FieldsAdapter(getActivity(), list, R.layout.fields_row);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(spanSpace);
        recyclerView.setAdapter(adapter);
        return v;
    }

}
