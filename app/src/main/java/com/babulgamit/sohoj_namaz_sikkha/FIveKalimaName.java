package com.babulgamit.sohoj_namaz_sikkha;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class FIveKalimaName extends Fragment {


    private static final String NAME = "NAME";

    private SimpleExpandableListAdapter mAdapter;
    ExpandableListView simpleExpandableListView;
    ExpandableListView kalimaExpandableListView;
    // string arrays for group and child items
    private String groupItems[] = {"১. কালেমা তাইয়্যিবাহ","২. কালেমা শাহাদত","৩. কালেমা তামজীদ",
            "৪. কালেমা তাওহীদ ","৫. কালেমা রদ্দে কুফর ","৬. কালেমা গুরুত্ব",};

    private String[][] childItems = {{"\nلآ اِلَهَ اِلّا اللّهُ مُحَمَّدٌ رَسُوُل اللّهِ" +
            "\n\nউচ্চারণ : লা ইলাহা ইল্লাল্লাহ মুহাম্মাদুর রাসুলুল্লাহ |\n" +
            "\nঅর্থ : আল্লাহ ছাড়া অন্য কেউ উপাস্য নাই এবং হযরত মুহাম্মদ (Saw) তাঁর প্রেরিত রসূল |\n"},

            {"\nاشْهَدُ انْ لّآ اِلهَ اِلَّا اللّهُ وَحْدَه لَا شَرِيْكَ لَه، وَ اَشْهَدُ اَنَّ مُحَمَّدً اعَبْدُهوَرَسُولُه" +
            "\n\n উচ্চারণ : আশহাদু আল লা-ইলাহা ইল্লাল্লাহু ওয়াহ্দাহু লা-শারিকালাহু ওয়াশহাদু আন্না মুহাম্মাদান আবদুহু ওয়া রাসুলুহু |\n" +
            "\nঅর্থ : আমি সাক্ষ্য দিচ্ছি যে, আল্লাহ ছাড়া অন্য কেউ ইবাদতের উপযুক্ত না এবং আল্লাহর কোন অংশীদার নেই | আমি আরো সাক্ষ্য দিচ্ছি যে, হযরত মুহাম্মদ(সাঃ ) আল্লার শ্রেষ্ঠ বান্দা এবং আল্লাহ প্রেরিত রসূল |\n"},

            {"\nسُبْحَان لِلّه وَ الْحَمْدُ   لِلّهِ وَ لآ اِلهَ اِلّا اللّهُ، وَ اللّهُ اَكْبَرُ وَلا حَوْلَ وَلاَ قُوَّة  ِلَّا بِاللّهِ الْعَلِىّ الْعَظِيْم" +
                    "\n\nউচ্চারণ : সুবহানআল্লাহি ওয়াল হামদু লিল্লাহি ওয়ালা ইলাহা ইল্লাল্লাহু ওয়াল্লাহু আকবার, ওয়ালা হাওলা ওয়ালা কুয়াতা ইল্লা বিল্লাহিল আলীইল আজিম |\n" +
                    "\nঅর্থ : মহিমান্বিত আল্লাহর, সমস্ত প্রশংসা আল্লাহর | আল্লাহ ছাড়া কোন মাবুদ নাই | আল্লাহ মহান | সমস্ত প্বিত্রতা আল্লাহর সকল প্রশংসা আল্লাহর | আল্লাহ ছাড়া কোন শক্তি নাই, কোন ক্ষমতা নাই, তিনি সম্মানিত, তিনি মহান |\n"},


            {"\nلا الهَ اِلَّا اللّهُ وَحْدَهُ لا شَرِيْكَ لَهْ، لَهُ الْمُلْكُ وَ لَهُ الْحَمْدُ يُحْى وَ يُمِيْتُ وَ هُوَحَىُّ لَّا يَمُوْتُ اَبَدًا اَبَدًا طذُو الْجَلَالِ وَ الْاِكْرَامِ ط بِيَدِهِ الْخَيْرُ ط وَهُوَ عَلى كُلِّ شَئ ٍ قَدِيْرٌ ط\n" +
                    "\n\n উচ্চারণ : লা ইলাহা ইল্লাল্লাহু ওয়াহ্দাহু লা শারিকা লাহু, লাহুল মুলকু ওলাহুল হামদু উহয়ী ওয়া ইয়োমিতু ওয়া হুয়া হাইয়ুল লা ইয়ামুতু আবাদান আবাদা জুল জালালী ওয়াল ইকরাম বি ইয়াদিহিল খাইর ওয়া হুয়া আলা কুল্লি শাইয়িন কাদীর |\n" +
                    "\nঅর্থ : আল্লাহ ব্যতীত কোন উপাস্য নেই | তিনি এক ও অদ্বিতীয় | তার কোন অংশীদার নেই | সকল ক্ষমতা এবং প্রশংসা তার জন্য | তিনি জীবন ও মৃত্যুর মালিক | তিনি চিরঞ্জীব, সকল সম্মানের মালিক | তার হাতেই সকল মঙ্গল সবকিছুর উপর তার ক্ষমতা রয়েছে |\n"},

            {"\nاَللّٰهُمَّ اِنِّیْٓ اَعُوْذُ بِكَ مِنْ اَنْ اُشْرِكَ بِكَ شَيْئًا وَّاَنَآ اَعْلَمُ بِهٖ وَ اَسْتَغْفِرُكَ لِمَا لَآ اَعْلَمُ بِهٖ تُبْتُ عَنْهُ وَ تَبَرَّأْتُ مِنَ الْكُفْرِ وَ الشِّرْكِ وَ الْكِذْبِ وَ الْغِيْبَةِ وَ الْبِدْعَةِ وَ النَّمِيْمَةِ وَ الْفَوَاحِشِ وَ الْبُهْتَانِ وَ الْمَعَاصِىْ كُلِّهَا وَ اَسْلَمْتُ وَ اَقُوْلُ لَآ اِلٰهَ اِلَّا اللهُ مُحَمَّدٌ رَّسُوْلُ اللهِؕ\n" +
                    "\n\nউচ্চারণ : আল্লাহুম্মা ইন্নি আউযুবিকা মিন আন উশরিকা বিকা শাইআও ওয়া আনা আলামু বিহি ওয়া আসতাগ ফিরুকা লিমা আলামু বিহি ওয়ামা লা আলামু বিহি তুবতু আনহু ওয়া তাবাররাতু মিনাল কুফরি ওয়াশ্শির্কি ওয়াল মা আছি কুল্লিহা ওয়া আসলামতু ওয়া আমানতু ওয়া আক্লু আল্লাহ ইলাহা ইল্লাল্লাহু মুহাম্মাদু রাসূলুল্লাহ |\n" +
                    "\nঅর্থ : হে আল্লাহ! আমি তোমার নিকট আশা প্রার্থনা করছি আশা করছি, যেন কাহাকেও তোমার সহিত কখনো অংশীদার না করি | আমার জানা – অজানা গুনাহ হতে ক্ষমা চাইতেছি এবং ইহা হতে তওবা করিতেছি | কুফর, শিরক এবং অন্যান্য সমস্ত গুনাহ হতে বিদূরিত হইতেছি | প্রতিজ্ঞা করিতেছি আল্লাহ ব্যতীত কোন মাবুদ নাই হজরত মুহাম্মদ (সাঃ ) তাঁহার রাসূল |\n"},

            {"\nআল্লাহ তাআলা মানবজাতিকে সৃষ্টির পর যুগে যুগে সত্যদ্বীনসহ নবী-রাসুল প্রেরণ করেছেন। তারা মানুষের কাছে আল্লাহর পরিচয় তুলে ধরেছেন। যারা এ দ্বীন গ্রহণ করেছেন, তারা মুক্তিপ্রাপ্ত দল। আর যারা প্রত্যাখ্যান করেছেন তারা জাহান্নামী। আল্লাহকে মানার বা বিশ্বাস করার মূলমন্ত্রই হচ্ছে এ কালিমা স্বীকৃতি। ঈমানদারের ওপর আল্লাহর বড় রহমত হচ্ছে, কালিমার স্বীকৃতি দেয়া। এ কালিমার স্বীকৃতি পারে একজন মানুষকে আখিরাতে মুক্তি দিতে।  এ সম্পর্কিত একটি হাদিস তুলে ধরা হলো-\n" +
                    "\n" +
                    "হজরত আব্দুল্লাহ ইবনে আমর ইবনুল আস রাদিয়াল্লাহু আনহু থেকে বর্ণিত, রাসল সাল্লাল্লাহু আলাইহি ওয়া সাল্লাম বলেছেন, `কিয়ামতের দিন আল্লাহ তাআলা আমার উম্মতের এক ব্যক্তিকে সবার সামনে নাজাত দিবেন, তার সামনে নিরানব্বইটি দফতর খোলা হবে, প্রত্যেক দফতর চোখের দৃষ্টি পরিমাণ লম্বা।\n" +
                    "\n" +
                    "অতঃপর তিনি বলবেন, তুমি এর কিছু অস্বীকার করো? আমার সংরক্ষণকারী লেখকরা তোমার ওপর জুলুম করেছে? সে বলবে, না, হে আমার রব! তিনি বলবেন, তোমার কোনো অজুহাত আছে? সে বলবে, না, হে আমার রব! তিনি বলবেন, নিশ্চয় আমার নিকট তোমার একটি নেকি রয়েছে, আজ তোমার ওপর কোনো জুলুম নেই।\n" +
                    "\n" +
                    "অতঃপর একটি বেতাকা/কার্ড বের হবে, যাতে রয়েছে- أَشْهَدُ أَنْ لَا إِلَهَ إِلَّا اللَّهُ وَأَشْهَدُ أَنَّ مُحَمَّدًا عَبْدُهُ وَرَسُولُهُ.\n" +
                    "উচ্চারণ : আশহাদু আল্লা ইলাহা ইল্লাল্লাহু ওয়া আশহাদু আন্না মুহাম্মাদান আবদুহু ওয়া রাসুলুহু।\n" +
                    "\n" +
                    "তিনি বলবেন, তোমার (কাজের /আমলের) ওজন প্রত্যক্ষ করো। সে বলবে, হে আমার রব! এতোগুলো দফতরের সঙ্গে মাত্র একটি কার্ড কি (কাজে আসবে)? তিনি বলবেন, নিশ্চয় তোমার ওপর জুলুম করা হবে না। তিনি বলেন, অতঃপর সবগুলো দফতর এক পাল্লায় ও কার্ডটি অপর পাল্লায় রাখা হবে, ফলে সব দফতর ওপরে উঠে যাবে ও কার্ডটির পাল্লা ভারী হবে। আল্লাহর নামের বিপরীতে কোনো জিনিস ভারী হবে না। (মুসনাদে আহমাদ, তিরমিজি, ইবনে মাজাহ)\n" +
                    "\n" +
                    "পরিশেষে...\n" +
                    "যেদিন আল্লাহর রহমত ছাড়া বান্দার কোনো উপায় থাকবে না। সেদিন কালেমায় বিশ্বাসী ব্যক্তি এ কালিমার ফজিলতে আল্লাহর রহমত লাভ করবে। আল্লাহ তাআলা আমাদেরকে আল্লাহর বিধানাবলী পালনের পাশাপাশি কালিমা শাহাদাতের আমল করার এবং ফজিলত লাভের তাওফিক দান করুন। আমিন।\n\n"},

    };










    public FIveKalimaName() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_five_kalima_name, container, false);



        //  initiate the expandable list view
        simpleExpandableListView = (ExpandableListView) view.findViewById(R.id.kalimaExpandableListView);
        // create lists for group and child items
        List<Map<String, String>> groupData = new ArrayList<Map<String, String>>();
        List<List<Map<String, String>>> childData = new ArrayList<List<Map<String, String>>>();
        // add data in group and child list


        for (int i = 0; i < groupItems.length; i++) {
            Map<String, String> curGroupMap = new HashMap<String, String>();
            groupData.add(curGroupMap);
            curGroupMap.put(NAME, groupItems[i]);

            List<Map<String, String>> children = new ArrayList<Map<String, String>>();
            for (int j = 0; j < childItems[i].length; j++) {
                Map<String, String> curChildMap = new HashMap<String, String>();
                children.add(curChildMap);
                curChildMap.put(NAME, childItems[i][j]);
            }
            childData.add(children);
        }
        // define arrays for displaying data in Expandable list view
        String groupFrom[] = {NAME};
        int groupTo[] = {R.id.heading};
        String childFrom[] = {NAME};
        int childTo[] = {R.id.childItem};


        // Set up the adapter
        mAdapter = new SimpleExpandableListAdapter(getContext(), groupData,
                R.layout.group_heading,
                groupFrom, groupTo,
                childData, R.layout.chiled_item,
                childFrom, childTo);
        simpleExpandableListView.setAdapter(mAdapter);

        // perform set on group click listener event
        simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                // display a toast with group name whenever a user clicks on a group item
                Toast.makeText(getContext(), "" + groupItems[groupPosition], Toast.LENGTH_LONG).show();

                return false;
            }
        });
        // perform set on child click listener event
        simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                // display a toast with child name whenever a user clicks on a child item
                Toast.makeText(getContext(), "" + childItems[groupPosition][childPosition], Toast.LENGTH_LONG).show();
                return false;
            }
        });
        return view;
    }

}
