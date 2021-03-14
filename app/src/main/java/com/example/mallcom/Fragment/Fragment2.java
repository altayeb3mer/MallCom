package com.example.mallcom.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mallcom.Adapter.AdapterDepts;
import com.example.mallcom.Adapter.AdapterDepts1;
import com.example.mallcom.Adapter.AdapterDepts2;
import com.example.mallcom.Models.ModelDept;
import com.example.mallcom.R;

import java.util.ArrayList;


public class Fragment2 extends Fragment {

    RecyclerView recyclerViewDept1,recyclerViewDept2;

    AdapterDepts1 adapterDepts1;
    AdapterDepts2 adapterDepts2;
    ArrayList<ModelDept> arrayList;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_2, container, false);
        init();
        return view;
    }

    private void init() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            ModelDept modelDept = new ModelDept();
            modelDept.setId(i+"");
            arrayList.add(modelDept);
        }
        recyclerViewDept1 = view.findViewById(R.id.recyclerDept1);
        recyclerViewDept2 = view.findViewById(R.id.recyclerDept2);

        initAdapter();

    }

    private void initAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false);
        recyclerViewDept1.setLayoutManager(gridLayoutManager);
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false);
        recyclerViewDept2.setLayoutManager(gridLayoutManager2);

        adapterDepts1 = new AdapterDepts1(getActivity(),arrayList);
        adapterDepts2 = new AdapterDepts2(getActivity(),arrayList);
        recyclerViewDept1.setAdapter(adapterDepts1);
        recyclerViewDept2.setAdapter(adapterDepts2);


    }



    Context context;
    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }


}