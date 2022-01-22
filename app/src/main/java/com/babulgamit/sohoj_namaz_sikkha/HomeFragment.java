package com.babulgamit.sohoj_namaz_sikkha;


import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private CardView  namajarrules,namajtimes,ozurules,allah99name,fivekalima,othersnamaj;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        namajarrules=view.findViewById(R.id.namajrulescardView_id);
        namajtimes=view.findViewById(R.id.namajtimecardView_id);
        ozurules=view.findViewById(R.id.ozuneyomcardView_id);
        allah99name=view.findViewById(R.id.nameofallahcardView_id);
        fivekalima=view.findViewById(R.id.fivekalimacardView_id);
        othersnamaj=view.findViewById(R.id.othersardView_id);


        namajarrules.setOnClickListener(this);
        namajtimes.setOnClickListener(this);
        ozurules.setOnClickListener(this);
        allah99name.setOnClickListener(this);
        fivekalima.setOnClickListener(this);
        othersnamaj.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {



        if (v.getId()==R.id.namajrulescardView_id)
        {
            NamajArRules namajArRules=new NamajArRules();
            FragmentTransaction transaction =getFragmentManager().beginTransaction();
            transaction.replace(R.id.home_main_id,namajArRules);
            transaction.commit();

        }
        else
       if (v.getId()==R.id.namajtimecardView_id)
        {
            NamajarTIme namajarTIme=new NamajarTIme();
            FragmentTransaction transaction =getFragmentManager().beginTransaction();
            transaction.replace(R.id.home_main_id,namajarTIme);
            transaction.commit();
        }
        else

         if (v.getId()==R.id.ozuneyomcardView_id)
        {
            OzurRules ozurRules=new OzurRules();
            FragmentTransaction transaction =getFragmentManager().beginTransaction();
            transaction.replace(R.id.home_main_id,ozurRules);
            transaction.commit();
        }
        else

            if (v.getId()==R.id.nameofallahcardView_id)
        {
            Allah99Name allah99Name=new Allah99Name();
            FragmentTransaction transaction =getFragmentManager().beginTransaction();
            transaction.replace(R.id.home_main_id,allah99Name);
            transaction.commit();
        }
        else

            if (v.getId()==R.id.fivekalimacardView_id)
        {
            FIveKalimaName fIveKalimaName=new FIveKalimaName();
            FragmentTransaction transaction =getFragmentManager().beginTransaction();
            transaction.replace(R.id.home_main_id,fIveKalimaName);
            transaction.commit();
        } else


            if (v.getId()==R.id.othersardView_id)
        {
            Toast.makeText(getContext(), "This is other activity", Toast.LENGTH_SHORT).show();
        }


    }
}
