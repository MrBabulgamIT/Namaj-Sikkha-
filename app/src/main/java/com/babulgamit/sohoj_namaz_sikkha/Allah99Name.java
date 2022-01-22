package com.babulgamit.sohoj_namaz_sikkha;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * A simple {@link Fragment} subclass.
 */
public class Allah99Name extends Fragment {

    MyAdapterAllahName myAdapterAllahName;
    RecyclerView recyclerView;
    String[] number,banglaName,banglameaning,arbiname;


    public Allah99Name() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_allah99_name, container, false);



        recyclerView=view.findViewById(R.id.allahnamerecyclerview_id);

        number=getResources().getStringArray(R.array.number);
        banglaName=getResources().getStringArray(R.array.allah_banglaName);
        banglameaning=getResources().getStringArray(R.array.allahnamebanla_meaning);
        arbiname=getResources().getStringArray(R.array.allah_Arbi_name);


        myAdapterAllahName=new MyAdapterAllahName(getContext(),number,banglaName,banglameaning,arbiname);

        recyclerView.setAdapter(myAdapterAllahName);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;

    }

}
